package lotto.entity

import lotto.entity.LottoTicket.Companion.LOTTO_NUMBER_LENGTH
import lotto.entity.LottoTicket.Companion.LOTTO_PRICE
import lotto.entity.LottoTicket.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.entity.LottoTicket.Companion.MINIMUM_LOTTO_NUMBER

object LottoTicketMachine {
    fun printMaxTicket(money: Int): List<LottoTicket> {
        return mutableListOf<LottoTicket>().apply {
            repeat(money / LOTTO_PRICE) { this.add(print()) }
        }.toList()
    }

    fun print(numbers: List<Int> = getRandomNumber()): LottoTicket {
        return LottoTicket(numbers)
    }

    fun getRandomNumber(): List<Int> {
        return (MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER).toList().shuffled().take(LOTTO_NUMBER_LENGTH)
    }
}
