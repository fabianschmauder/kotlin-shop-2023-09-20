package de.neuefische.kotlinworkshop.controller

import de.neuefische.kotlinworkshop.domain.Product
import de.neuefische.kotlinworkshop.service.ProductService
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [ProductController::class])
class ProductControllerTest {

    @MockBean
    lateinit var productService: ProductService

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `search for products`() {

        Mockito.`when`(productService.list("p")).thenReturn(listOf(Product(id = "id1", name = "Product")))

        mockMvc.perform(get("/product?search=p")).andExpect(status().isOk())
            .andExpect(
                content().json(
                    """[{
                        "id": "id1",
                        "name": "Product"
                        }]"""
                )
            )
    }


}
