package de.neuefische.kotlinworkshop.service

import org.springframework.stereotype.Service

@Service
class ProductService {

    fun list() = listOf("product", "product2")
}
