package lotto.model

import lotto.model.LottoTicket.Companion.NUMBER_COUNT
import java.text.DecimalFormat


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

    fun getProfit(): Double {
        val ticketCount = results.values.sum()

        val sumOfPrize = results.entries.fold(0) { sum, (key, value) ->
            sum + value * Prize.getPrizePerMatch(key)
        }

        return DecimalFormat("#.##").format(sumOfPrize.toDouble() / (LottoTicket.TICKET_PRICE * ticketCount).toDouble()).toDouble()
    }
}

