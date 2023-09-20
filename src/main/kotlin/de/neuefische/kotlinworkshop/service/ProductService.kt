package de.neuefische.kotlinworkshop.service

import de.neuefische.kotlinworkshop.domain.Product
import org.springframework.stereotype.Service

@Service
class ProductService {

    private val products = listOf(
        Product(
            id = "id1",
            name = "Super Product"
        ), Product(
            id = "id2",
            name = "nice Product"
        )
    )


    fun list(search: String?, from: Int = 0, size: Int = 10): List<Product> {
        search ?: return products.pageing(from,size)
        return products.filterBy(name = search).pageing(from,size)
    }

    fun getById(id: String) = products.firstOrNull { product -> product.id == id }
}
