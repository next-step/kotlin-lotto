package lotto.controller

object GeneratorRandomNumbers {
    private val LOTTO_NUMBERS = (1..45)
    fun generateNumbers(count: Int): List<Int> {
        val shuffledNumbers = LOTTO_NUMBERS.shuffled()
        return shuffledNumbers.take(count).toList()
    }
}
