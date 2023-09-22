package de.neuefische.kotlinworkshop.dto

import java.time.Instant

data class NorrisJoke(val value: String, var time: Instant = Instant.now())
