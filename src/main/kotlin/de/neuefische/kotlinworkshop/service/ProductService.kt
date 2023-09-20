package de.neuefische.kotlinworkshop.service

import de.neuefische.kotlinworkshop.domain.Product
import org.springframework.stereotype.Service

@Service
class ProductService {

    private val products  = listOf(
        Product(
            id = "id1",
            name = "Super Product"
        ), Product(
            id = "id2",
            name = "nice Product"
        )
    )


    fun list(search: String) = products.filter { product -> product.name.contains(search, true) }
}
