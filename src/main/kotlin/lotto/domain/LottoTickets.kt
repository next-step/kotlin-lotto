package lotto.domain

import lotto.domain.strategy.NumberGenerateStrategy

class LottoTickets(val tickets: List<LottoTicket>) {
    fun getMatchCounts(numbers: LottoTicket): List<Int> {
        return tickets.map { it.getMatchCount(numbers) }
    }

    companion object {
        fun create(count: Int, numberStrategy: NumberGenerateStrategy): LottoTickets {
            return LottoTickets((1..count).map { LottoTicket.create(numberStrategy) }.toList())
        }
    }
}
