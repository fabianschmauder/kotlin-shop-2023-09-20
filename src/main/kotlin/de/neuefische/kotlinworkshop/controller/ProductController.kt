package de.neuefische.kotlinworkshop.controller

import de.neuefische.kotlinworkshop.domain.Product
import de.neuefische.kotlinworkshop.dto.AddProductDto

import de.neuefische.kotlinworkshop.service.ProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("product")
class ProductController(private val service: ProductService) {

    @GetMapping
    fun listProducts(@RequestParam search: String?, @RequestParam from: Int? , @RequestParam size: Int?  ): List<Product> {
        return service.list(search, from?: 0, size?: 10)
    }

    @GetMapping("{id}")
    fun getProduct(@PathVariable id: String) = service.getById(id)
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "product with id $id not found")

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addProduct(@Valid @RequestBody productData: AddProductDto): Product {

        if(productData.name.isBlank()){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "name is blank")
        }
        return service.addProduct(productData.name)
    }


    @GetMapping("category")
    fun listByCategory() = service.listByCategory()

}
