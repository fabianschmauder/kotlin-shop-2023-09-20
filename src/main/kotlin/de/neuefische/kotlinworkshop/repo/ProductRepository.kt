package de.neuefische.kotlinworkshop.repo

import de.neuefische.kotlinworkshop.domain.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, String> {

    fun getByName(id: String): Product?
}
