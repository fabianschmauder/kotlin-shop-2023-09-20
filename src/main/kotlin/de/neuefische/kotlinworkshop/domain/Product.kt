package de.neuefische.kotlinworkshop.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "product")
class Product(
    @Id
    @Column
    var id: String = "",
    @Column
    var name: String = "",
    @Column
    var type: ProductType = ProductType.FOOD
)
