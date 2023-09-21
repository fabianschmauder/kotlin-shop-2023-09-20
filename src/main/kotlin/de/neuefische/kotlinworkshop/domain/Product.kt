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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false
        if (name != other.name) return false
        return type == other.type
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }
}
