package de.neuefische.kotlinworkshop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean


@SpringBootApplication
class KotlinWorkshopApplication{
    @Bean
    fun validator(): LocalValidatorFactoryBean? {
        return LocalValidatorFactoryBean()
    }
}

fun main(args: Array<String>) {
    runApplication<KotlinWorkshopApplication>(*args)
}

