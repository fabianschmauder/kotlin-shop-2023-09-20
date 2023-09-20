package de.neuefische.kotlinworkshop.service

import de.neuefische.kotlinworkshop.domain.Product

fun List<Product>?.filterBy(name: String): List<Product> {
    return this?.filter { product -> product.name.contains(name, true) } ?: listOf()
}
fun List<Product>.pageing(from: Int, size: Int): List<Product> {
    return this.drop(from).take( size)
}


