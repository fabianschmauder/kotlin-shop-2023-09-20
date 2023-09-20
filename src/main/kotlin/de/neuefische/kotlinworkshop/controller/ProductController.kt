package de.neuefische.kotlinworkshop.controller

import de.neuefische.kotlinworkshop.domain.Product
import de.neuefische.kotlinworkshop.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("product")
class ProductController(private val service: ProductService) {

    @GetMapping
    fun listProducts(@RequestParam search: String?): List<Product> {
        return service.list(search)
    }

    @GetMapping("{id}")
    fun getProduct(@PathVariable id: String) = service.getById(id)
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "product with id $id not found")
}
