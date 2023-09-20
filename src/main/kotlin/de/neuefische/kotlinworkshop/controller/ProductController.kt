package de.neuefische.kotlinworkshop.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("product")
class ProductController {

    @GetMapping
    fun listProducts() = listOf("product", "product2")
}
