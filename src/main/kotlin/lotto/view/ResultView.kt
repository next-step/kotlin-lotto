package lotto.view

import lotto.domain.LottoStatistics
import lotto.domain.LottoTicket
import lotto.domain.WinningAmount

object ResultView {

    fun printTicketAmount(amount: Int) {
        println("${amount}개를 구매했습니다.")
    }

    fun printTicketBundle(ticketBundle: List<LottoTicket>) {
        repeat(ticketBundle.size) {
            println("${ticketBundle[it].numbers}")
        }
    }

    fun printWinningLottoAmount(lottoStatistics: LottoStatistics) {
        lottoStatistics.rank.entries
            .filter { it.key != WinningAmount.LOSING_TICKET }
            .forEach {
                println("${it.key.getMatchCount()}개 일치 (${it.key.amount}원)- ${it.value}개")
            }
    }

    fun printRateOfReturn(rate: Double) {
        println("총 수익률은 ${rate}입니다.")
    }
}
