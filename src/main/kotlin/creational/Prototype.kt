package creational

sealed class Shape(open val x: Int, open val y: Int)

data class Rect(
    override val x: Int, override val y: Int,
    val width: Int, val height: Int
) : Shape(x, y)

data class Circle(
    override val x: Int, override val y: Int,
    val radius: Int
) : Shape(x, y)

fun main() {
    val circle = Circle(0, 0, 5)
    val shapes = mutableListOf(
        Rect(0, 0, 10, 10),
        circle
    )
    shapes.run {
        add(circle.copy(x = 4, y = 5))
        add(circle.copy(radius = 3))

        forEach(::println)
    }
}
