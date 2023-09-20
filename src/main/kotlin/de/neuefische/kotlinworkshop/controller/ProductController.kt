package de.neuefische.kotlinworkshop.controller

import de.neuefische.kotlinworkshop.domain.Product
import de.neuefische.kotlinworkshop.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("product")
class ProductController(private val service: ProductService) {

    @GetMapping
    fun listProducts(@RequestParam search: String): List<Product> = service.list(search)
}
