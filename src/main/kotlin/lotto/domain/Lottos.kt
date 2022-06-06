package lotto.domain

import lotto.domain.enum.Priority

class Lottos(val tickets: List<LottoTicket>) {
    private val priorities = mutableMapOf<Priority, Int>()

    init {
        for (priority in Priority.values()) {
            priorities[priority] = 0
        }
    }

    fun calculatePriorities(
        winningTicket: WinningTicket
    ): Map<Priority, Int> {
        for (ticket in tickets) {
            priorities.merge(ticket.priority(winningTicket), 1, Int::plus)
        }

        return priorities
    }

    companion object {
        fun of(lottoNumbers: List<Set<LottoNumber>>): Lottos {
            val tickets = mutableListOf<LottoTicket>()
            for (lottoNumber in lottoNumbers) {
                tickets.add(LottoTicket(lottoNumber))
            }

            return Lottos(tickets)
        }
    }
}
