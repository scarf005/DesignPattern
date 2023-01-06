package creational

interface Burger {
    val patties: Int
}

interface Drink {
    val ml: Int
}

data class Whopper(override val patties: Int = 1) : Burger
data class Pepsi(override val ml: Int = 1250) : Drink

data class BigMac(override val patties: Int = 2) : Burger
data class McFlurry(override val ml: Int = 500) : Drink

interface Burgeria {
    fun Burger(): Burger
    fun Drink(): Drink
}

class BurgerKing : Burgeria {
    override fun Burger() = Whopper()
    override fun Drink() = Pepsi()
}

class McDonalds : Burgeria {
    override fun Burger() = BigMac()
    override fun Drink() = McFlurry()
}

fun main() = listOf(BurgerKing(), McDonalds()).forEach {
    println("ordering at ${it.javaClass.simpleName}:")
    println("Burger: ${it.Burger()}")
    println("Drink: ${it.Drink()}")
}
