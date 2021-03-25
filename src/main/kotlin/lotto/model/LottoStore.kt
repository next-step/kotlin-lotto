package lotto.model

import lotto.model.number.LottoNumbers

class LottoStore(private val generator: NumbersGenerator) {
    fun buy(moneyAmount: Money, listOfCandidateNumbers: List<LottoNumbers> = listOf()): LottoTickets {
        val manualTickets = LottoTickets(listOfCandidateNumbers.map { LottoTicket(it) })

        val affordableAutoTicketsCount = (moneyAmount / LottoTicket.PRICE).toInt() - manualTickets.size

        return manualTickets + LottoTickets.issue(affordableAutoTicketsCount, generator)
    }
}
