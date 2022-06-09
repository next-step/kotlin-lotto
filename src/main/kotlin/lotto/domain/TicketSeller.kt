package lotto.domain

import lotto.util.RandomGenerate

class TicketSeller(private val ticketPrice: Money, private val randomGenerate: RandomGenerate) {

    fun buyPossibleLottoTicket(userMoney: Money): List<LottoTicket> {
        return List(userMoney.value / ticketPrice.value) {
            LottoTicket.ofInts(
                randomGenerate.makeRandomUniqueIntList(
                    LottoTicketNumbers.LOTTO_TICKET_NUMBER_SIZE,
                    LottoTicketNumber.LOTTO_NUMBER_RANGE
                )
            )
        }
    }
}
