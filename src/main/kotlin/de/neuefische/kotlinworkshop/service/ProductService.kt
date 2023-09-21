package de.neuefische.kotlinworkshop.service

import de.neuefische.kotlinworkshop.domain.Product
import de.neuefische.kotlinworkshop.domain.ProductType
import org.springframework.stereotype.Service
import java.util.UUID


typealias ProductCategories = Map<ProductType, List<Product>>

@Service
class ProductService {

    private val products = mutableListOf(
        Product(
            id = "id1",
            name = "Super Product",
            type = ProductType.FOOD
        ), Product(
            id = "id2",
            name = "nice Product",
            type = ProductType.NON_FOOD
        )
    )


    fun list(search: String?, from: Int = 0, size: Int = 10): List<Product> {
        search ?: return products.pageing(from, size)
        return products.filterBy(name = search).pageing(from, size)
    }

    fun getById(id: String) = products.firstOrNull { product -> product.id == id }
    fun addProduct(name: String): Product {


        val product = Product(
            id = UUID.randomUUID().toString(),
            name = name.trim(),
            type = ProductType.NON_FOOD
        )
        products += product
        return product
    }

    fun listByCategory(): ProductCategories {
        return this.products.groupBy { product -> product.type }

    }

}
