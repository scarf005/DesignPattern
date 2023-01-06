package structural

import kotlin.math.sqrt

data class RoundHole(val radius: Int) {
    fun fits(peg: RoundPeg) = radius >= peg.radius
}

open class RoundPeg(val radius: Int)
class SquarePeg(val width: Int)

fun wrapSquareToRound(width: Int) = (width * sqrt(2.0) / 2.0).toInt()

class SquarePegAdapter(peg: SquarePeg) : RoundPeg(wrapSquareToRound(peg.width))

fun SquarePeg.toRoundPeg() = RoundPeg(wrapSquareToRound(width))

fun main() {
    val hole = RoundHole(5)
    val round = RoundPeg(5)
    val square = SquarePeg(4)
    val squareAdapter = SquarePegAdapter(square)
    val squareAdapter2 = square.toRoundPeg()

    for (peg in listOf(round, squareAdapter, squareAdapter2)) {
        println("hole fits peg? : ${hole.fits(peg)}")
    }
}
