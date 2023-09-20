package de.neuefische.kotlinworkshop.service

import de.neuefische.kotlinworkshop.domain.Product
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.hamcrest.Matchers.`is` as Is
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {

    @Autowired
    lateinit var productService: ProductService

    @Test
    fun `filter list products`() {

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

    @Test
    fun `get by id should return item wIth id`() {
        val result = productService.getById("id1")

        assertThat(
            result, Is(
                Product(
                    id = "id1",
                    name = "Super Product"
                )
            )
        )
    }
}
