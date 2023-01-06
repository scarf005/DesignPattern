package creational

data class House(
    val windows: Int = 0,
    val doors: Int = 1,
    val rooms: Int = 1,
    val hasGarage: Boolean = false,
    val hasSwimPool: Boolean = false,
    val hasStatues: Boolean = false,
    val hasGarden: Boolean = false,
)

val minimalistHouse = House()
val mansion = House(
    windows = 20,
    doors = 10,
    rooms = 20,
    hasGarage = true,
    hasSwimPool = true,
    hasStatues = true,
    hasGarden = true,
)
val richHouse = House(
    windows = 10,
    doors = 2,
    rooms = 5,
    hasGarage = true,
    hasSwimPool = true,
    hasStatues = true,
    hasGarden = true,
)

fun main() = listOf(minimalistHouse, mansion, richHouse).forEach(::println)
