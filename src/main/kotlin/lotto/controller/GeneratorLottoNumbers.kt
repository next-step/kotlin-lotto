package lotto.controller

import lotto.controller.GeneratorLottoNumbers.Companion.COUNT_OF_NUMBERS

fun interface GeneratorLottoNumbers {
    fun generateNumbers(): List<Int>

    companion object {
        const val COUNT_OF_NUMBERS = 6
    }
}

object GeneratorRandomNumbers : GeneratorLottoNumbers {
    private val LOTTO_NUMBERS = (1..45)

    override fun generateNumbers(): List<Int> {
        val shuffledNumbers = LOTTO_NUMBERS.shuffled()
        return shuffledNumbers.take(COUNT_OF_NUMBERS).toList()
    }
}
