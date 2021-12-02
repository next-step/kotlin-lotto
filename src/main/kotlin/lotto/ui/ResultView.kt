package lotto.ui

import lotto.domain.Rank
import lotto.domain.Ticket

/**
 *
 * @author Leo
 */
class ResultView {

    fun showResult(result: Map<Rank, List<Ticket>>) {
        println("")
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${defaultZeroSize(result[Rank.FOURTH])}개")
        println("4개 일치 (50000원)- ${defaultZeroSize(result[Rank.THIRD])}개")
        println("5개 일치 (1500000원)- ${defaultZeroSize(result[Rank.SECOND])}개")
        println("6개 일치 (2000000000원)- ${defaultZeroSize(result[Rank.FIRST])}개")
    }

    fun showEarnings(earnings: Double) {
        println("총 수익률은 ${earnings}입니다.")
    }

    private fun defaultZeroSize(tickets: List<Ticket>?): Int {
        if (tickets == null) {
            return 0
        }

        return tickets.size
    }

}