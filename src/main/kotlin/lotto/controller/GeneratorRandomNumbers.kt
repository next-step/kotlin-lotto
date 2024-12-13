package lotto.controller

import lotto.domain.LottoTicket

object GeneratorRandomNumbers {
    private val LOTTO_NUMBERS = (1..45)

    fun generateLottoTicker(): LottoTicket {
        val shuffledNumbers = LOTTO_NUMBERS.shuffled()
        return LottoTicket(shuffledNumbers.take(6).toList())
    }

    fun generateNumbers(count: Int): List<Int> {
        val shuffledNumbers = LOTTO_NUMBERS.shuffled()
        return shuffledNumbers.take(count).toList()
    }
}
