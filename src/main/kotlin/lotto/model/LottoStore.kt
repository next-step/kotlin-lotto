package lotto.model

import lotto.model.number.CandidateNumbers

class LottoStore {
    fun buy(moneyAmount: Money, listOfCandidateNumbers: List<CandidateNumbers> = listOf()): LottoTickets {
        val manualTickets = LottoTickets(listOfCandidateNumbers.map { LottoTicket(it) })

        val affordableAutoTicketsCount = (moneyAmount / LottoTicket.PRICE).toInt() - manualTickets.size

        return manualTickets + LottoTickets.issue(affordableAutoTicketsCount)
    }
}
