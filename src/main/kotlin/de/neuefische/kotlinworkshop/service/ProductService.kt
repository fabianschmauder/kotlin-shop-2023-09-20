package de.neuefische.kotlinworkshop.service

import de.neuefische.kotlinworkshop.domain.Product
import de.neuefische.kotlinworkshop.domain.ProductType
import de.neuefische.kotlinworkshop.repo.ProductRepository
import org.springframework.stereotype.Service
import java.util.UUID
import kotlin.jvm.optionals.getOrNull


typealias ProductCategories = Map<ProductType, List<Product>>

@Service
class ProductService(private val productRepo: ProductRepository) {


    fun list(search: String?, from: Int = 0, size: Int = 10): List<Product> {
        search ?: return productRepo.findAll().pageing(from, size)
        return productRepo.findAll().filterBy(name = search).pageing(from, size)
    }

    fun getById(id: String) = productRepo.findById(id).getOrNull()
    fun addProduct(name: String): Product = productRepo.save(
        Product(
            id = UUID.randomUUID().toString(),
            name = name.trim(),
            type = ProductType.NON_FOOD
        )
    )

    fun listByCategory(): ProductCategories {
        return productRepo.findAll().groupBy { product -> product.type }

    }

}
