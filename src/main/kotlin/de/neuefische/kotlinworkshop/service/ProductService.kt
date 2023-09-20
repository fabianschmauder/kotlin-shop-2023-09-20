package de.neuefische.kotlinworkshop.service

import de.neuefische.kotlinworkshop.domain.Product
import org.springframework.stereotype.Service

@Service
class ProductService {

    fun list() = listOf(
        Product(
            id = "id1",
            name = "Super Product"
        ), Product(
            id = "id2",
            name = "nice Product"
        )
    )
}
