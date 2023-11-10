package lotto.model

import lotto.model.LottoTicket.Companion.NUMBER_COUNT


class LottoResults(lottoTickets: List<LottoTicket>, winningNumbers: List<LottoNumber>) {
    var results: MutableMap<Int, Int> = (0..NUMBER_COUNT + 1).associateWith { 0 }.toMutableMap()
        private set

    init {
        lottoTickets.forEach { lottoTicket ->
            getMatchCount(winningNumbers, lottoTicket).let { matchCount -> results[matchCount] = results[matchCount]!! + 1 }
        }
    }
    private fun getMatchCount(winningNumbers: List<LottoNumber>, lottoTicket: LottoTicket): Int =
        lottoTicket.numbers.intersect(winningNumbers.toSet()).size

}

