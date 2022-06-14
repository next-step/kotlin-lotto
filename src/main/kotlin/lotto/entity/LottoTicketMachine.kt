package lotto.entity

import lotto.entity.LottoTicket.Companion.LOTTO_NUMBER_LENGTH
import lotto.entity.LottoTicket.Companion.LOTTO_PRICE

object LottoTicketMachine {
    private const val minimumLottoNumber = 1
    private const val maximumLottoNumber = 45

    fun printMaxTicket(money: Int): List<LottoTicket> {
        return mutableListOf<LottoTicket>().apply {
            repeat(money / LOTTO_PRICE) { this.add(print()) }
        }.toList()
    }

    fun print(numbers: List<Int> = getRandomNumber()): LottoTicket {
        return LottoTicket(numbers)
    }

    fun getRandomNumber(): List<Int> {
        return (minimumLottoNumber..maximumLottoNumber).toList().shuffled().take(LOTTO_NUMBER_LENGTH)
    }
}
