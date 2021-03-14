package lotto.domain

import lotto.domain.strategy.NumberGenerateStrategy

class LottoTickets(val tickets: List<LottoTicket>) {
    fun getMatchCounts(numbers: List<LottoNumber>): List<Int> {
        return tickets.map { it.getMatchCount(numbers) }
    }

    companion object {
        fun create(count: Int, numberStrategy: NumberGenerateStrategy): LottoTickets {
            return LottoTickets(
                mutableListOf<LottoTicket>()
                    .also { tickets -> repeat(count) { tickets.add(LottoTicket.create(numberStrategy)) } }
            )
        }
    }
}
