package lotto.view

import lotto.domain.LottoTicket
import lotto.domain.TicketCount
import lotto.dto.LottoMatchResult
import lotto.dto.LottoTicketsResult
import lotto.enum.Rank

object ResultView {

    fun showTickets(ticketsResult: LottoTicketsResult) {
        val manualCount = TicketCount(ticketsResult.manualTicketsCount)
        val automaticCount = TicketCount(ticketsResult.tickets.size - manualCount.count)
        formatPrintln("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCount.count, automaticCount.count)
        showTicketList(ticketsResult.tickets)
    }

    private fun showTicketList(tickets: List<LottoTicket>) {
        tickets.forEach { ticket ->
            val ticketNumbersString = ticket.readOnlyNumbers.joinToString(", ") { number -> number.number.toString() }
            formatPrintln("[$ticketNumbersString]")
        }
    }

    fun showReturnRate(returnRate: Double) {
        formatPrintln("총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)", returnRate)
    }

    fun showStatistics(matchResult: LottoMatchResult) {
        println("당첨 통계\n---------")
        showMatchCountsStatistics(matchResult)
        showBonusMatchStatistics(matchResult)
    }

    private fun showMatchCountsStatistics(matchResult: LottoMatchResult) {
        (3..6).forEach { matchCount ->
            val count = matchResult.getMatchCount(matchCount)
            val isBonusMatch = matchCount == 5 && matchResult.bonusMatchCount > 0
            val reward = Rank.determineRank(matchCount, isBonusMatch).winningMoney
            formatPrintln("%d개 일치 (%d원)- %d개", matchCount, reward, count)
        }
    }

    private fun showBonusMatchStatistics(matchResult: LottoMatchResult) {
        if (matchResult.bonusMatchCount > 0) {
            val bonusReward = Rank.SECOND.winningMoney
            formatPrintln("5개 일치, 보너스 볼 일치(%d원) - %d개", bonusReward, matchResult.bonusMatchCount)
        }
    }

    private fun formatPrintln(format: String, vararg args: Any?) {
        println(String.format(format, *args))
    }
}
