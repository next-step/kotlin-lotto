package lotto.util

object RandomNumbers : AutoNumbers {
    private const val BOUND = 45
    private const val SIZE = 6
    private val LOTTO_NUMBERS: List<Int> = List(BOUND) { it + 1 }

    override fun generateNumbers(): List<Int> {
        return LOTTO_NUMBERS.shuffled().take(SIZE)
    }
}
