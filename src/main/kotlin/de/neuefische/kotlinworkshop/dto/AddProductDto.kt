package de.neuefische.kotlinworkshop.dto

import jakarta.validation.constraints.Min

data class AddProductDto(val name: String,
                         @Min(10, message = "min 10")
                         val number: Int  = 0)
