package lotto.entity

import lotto.entity.LottoTicket.Companion.LOTTO_NUMBER_LENGTH
import lotto.entity.LottoTicket.Companion.LOTTO_PRICE
import lotto.entity.LottoTicket.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.entity.LottoTicket.Companion.MINIMUM_LOTTO_NUMBER

object LottoTicketMachine {
    fun printMaxTicket(wallet: Wallet): Wallet {
        val tickets = wallet.tickets.toMutableList()
        repeat(wallet.money / LOTTO_PRICE) {
            tickets.add(print())
        }
        return Wallet(wallet.money % LOTTO_PRICE, tickets.toList())
    }

    fun print(numbers: List<Int> = getRandomNumber()): LottoTicket {
        return LottoTicket(numbers)
    }

    fun getRandomNumber(): List<Int> {
        return (MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER).toList().shuffled().take(LOTTO_NUMBER_LENGTH)
    }
}
