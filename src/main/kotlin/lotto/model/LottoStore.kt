package lotto.model

import lotto.model.number.LottoNumber
import lotto.model.number.LottoNumbers

class LottoStore(private val generator: NumbersGenerator) {
    fun buy(moneyAmount: Money, listOfCandidateNumbers: List<LottoNumbers> = listOf()): LottoTickets {
        val manualTickets = LottoTickets(listOfCandidateNumbers.map { LottoTicket(it) })

        return manualTickets + LottoTickets(
            (1..calculateAutoTicketCount(moneyAmount, manualTickets.size)).map {
                LottoTicket(generator.getNumbers(LottoNumber.MAXIMUM, LottoNumbers.CANDIDATE_SIZE))
            }
        )
    }

    private fun calculateAutoTicketCount(
        moneyAmount: Money,
        manualTicketCount: Int
    ) = (moneyAmount / LottoTicket.PRICE).toInt() - manualTicketCount
}
