package de.neuefische.kotlinworkshop.controller

import de.neuefische.kotlinworkshop.dto.NorrisJoke
import de.neuefische.kotlinworkshop.service.NorrisService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RequestMapping("norris")
@RestController
class NorrisController(private val norrisService: NorrisService) {

    @GetMapping
    suspend fun getJoke(): List<NorrisJoke> {
        return norrisService.getJoke()
    }
}
