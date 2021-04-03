package lotto.model

import lotto.model.number.LottoNumbers

class LottoStore(private val generator: NumbersGenerator) {
    fun buy(moneyAmount: Money, listOfCandidateNumbers: List<LottoNumbers> = listOf()): LottoTickets {
        val manualTickets = LottoTickets(listOfCandidateNumbers.map { LottoTicket(it) })

        return manualTickets + LottoTickets.issue(
            calculateAutoTicketCount(moneyAmount, manualTickets.size),
            generator
        )
    }

    private fun calculateAutoTicketCount(
        moneyAmount: Money,
        manualTicketCount: Int
    ) = (moneyAmount / LottoTicket.PRICE).toInt() - manualTicketCount
}
