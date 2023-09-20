package de.neuefische.kotlinworkshop.service

import de.neuefische.kotlinworkshop.domain.Product

fun List<Product>?.filterBy(name: String): List<Product> {
    return this?.filter { product -> product.name.contains(name, true) } ?: listOf()
}

