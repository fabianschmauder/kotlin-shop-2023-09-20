package de.neuefische.kotlinworkshop.service

import de.neuefische.kotlinworkshop.domain.Product
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {

    @Autowired
    lateinit var productService: ProductService

    @Test
    fun filterListProducts() {

        val result = productService.list("Super")

        assertThat(
            result, containsInAnyOrder(
                Product(
                    id = "id1",
                    name = "Super Product"
                )
            )
        )
    }
}
