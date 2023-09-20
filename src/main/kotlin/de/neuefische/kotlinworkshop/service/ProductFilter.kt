package de.neuefische.kotlinworkshop.service

import de.neuefische.kotlinworkshop.domain.Product

fun filterProducts(products: List<Product>,search: String ) = products.filter { product -> product.name.contains(search, true) }
