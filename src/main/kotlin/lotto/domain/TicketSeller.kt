package lotto.domain

import lotto.util.RandomGenerate

class TicketSeller(private val randomGenerate: RandomGenerate, ticketPrice: Money = Money(1000)) {
    val ticketPrice = ticketPrice
        get() = Money(field.value)

    fun buyPossibleLottoTicket(userMoney: Money): List<LottoTicket> {
        return List((userMoney.value / ticketPrice.value).toInt()) {
            LottoTicket.ofInts(
                randomGenerate.makeRandomUniqueIntList(
                    LottoTicketNumbers.LOTTO_TICKET_NUMBER_SIZE,
                    LottoTicketNumber.LOTTO_NUMBER_RANGE
                )
            )
        }
    }
}
