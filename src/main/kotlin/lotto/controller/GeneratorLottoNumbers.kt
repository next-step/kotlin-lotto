package lotto.controller

import lotto.controller.GeneratorLottoNumbers.Companion.COUNT_OF_NUMBERS
import lotto.domain.LottoNumber

fun interface GeneratorLottoNumbers {
    fun generateNumbers(): List<LottoNumber>

    companion object {
        const val COUNT_OF_NUMBERS = 6
    }
}

object GeneratorRandomNumbers : GeneratorLottoNumbers {
    private val LOTTO_NUMBERS = (1..45).map { LottoNumber(it) }

    override fun generateNumbers(): List<LottoNumber> {
        val shuffledNumbers = LOTTO_NUMBERS.shuffled()
        return shuffledNumbers.take(COUNT_OF_NUMBERS).toList()
    }
}
