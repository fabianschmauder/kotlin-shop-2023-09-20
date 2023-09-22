package de.neuefische.kotlinworkshop.service

import de.neuefische.kotlinworkshop.dto.NorrisJoke
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class NorrisService {
    val webClient: WebClient = WebClient.create("https://api.chucknorris.io/")

    suspend fun getJoke() = coroutineScope {
        val list = mutableListOf<Deferred<NorrisJoke>>()
        repeat(100) {
            list += async {
                webClient.get()
                    .uri("jokes/random")
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve().awaitBody<NorrisJoke>()
            }
        }
        list.awaitAll()
    }

}
