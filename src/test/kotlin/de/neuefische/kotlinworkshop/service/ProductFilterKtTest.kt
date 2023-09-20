package de.neuefische.kotlinworkshop.service

import de.neuefische.kotlinworkshop.domain.Product
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Test

class ProductFilterKtTest {

    @Test
    fun `blank search string should return all products 🦙 💥`() {
        // GIVEN
        val products = listOf(
            Product(
                id = "id1",
                name = "Product 1"
            ), Product(
                id = "id2",
                name = "Product 2"
            )
        )

        //WHEN
        val result = products.filterBy(name = "")

        //THEN
        assertThat(result, containsInAnyOrder(   Product(
            id = "id1",
            name = "Product 1"
        ), Product(
            id = "id2",
            name = "Product 2"
        )))
    }

    @Test
    fun `search string should filter product by name`() {
        // GIVEN
        val products = listOf(
            Product(
                id = "id1",
                name = "Eis"
            ), Product(
                id = "id2",
                name = "Genüse"
            )
        )

        //WHEN
        val result = products.filterBy(name ="eis")

        //THEN
        assertThat(result, containsInAnyOrder(   Product(
            id = "id1",
            name = "Eis"
        )))
    }
}
