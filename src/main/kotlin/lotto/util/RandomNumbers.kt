package lotto.util

object RandomNumbers : AutoNumbers {
    private const val BOUND = 45
    private const val SIZE = 6
    private var LOTTO_NUMBERS: List<Int> = List(BOUND) { it + 1 }

    override fun generateNumbers(): List<Int> {
        LOTTO_NUMBERS = LOTTO_NUMBERS.shuffled()
        return List(SIZE) { LOTTO_NUMBERS[it] }
    }
}
