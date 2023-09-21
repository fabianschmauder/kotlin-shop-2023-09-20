package de.neuefische.kotlinworkshop.service

import de.neuefische.kotlinworkshop.domain.Product
import de.neuefische.kotlinworkshop.repo.ProductRepository
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.hamcrest.Matchers.`is` as Is
import org.junit.jupiter.api.Test
import java.util.*

class ProductServiceTest {

    val repo = mockk<ProductRepository>()

    var productService: ProductService = ProductService(repo)

    @Test
    fun `filter list products`() {
        every { repo.findAll() } returns listOf(
            Product(
                id = "id1",
                name = "Super Product"
            )
        )

        every { repo.findById("id1") } returns Optional.of(
            Product(
                id = "id1",
                name = "Super Product"
            )
        )

        val result = productService.list("Super")

        assertThat(
            result, containsInAnyOrder(
                Product(
                    id = "id1",
                    name = "Super Product"
                )
            )
        )

        verify { repo.findAll() }
        confirmVerified(repo)
    }

    @Test
    fun `get by id should return item wIth id`() {
        every { repo.findById("id1") } returns Optional.of(
            Product(
                id = "id1",
                name = "Super Product"
            )
        )


        val result = productService.getById("id1")

        assertThat(
            result, Is(
                Product(
                    id = "id1",
                    name = "Super Product"
                )
            )
        )
        verify { repo.findById("id1") }
    }


}
