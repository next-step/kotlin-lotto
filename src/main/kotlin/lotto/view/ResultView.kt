package lotto.view

import lotto.domain.LottoConstants
import lotto.domain.LottoTicket
import lotto.dto.LottoMatchResult

object ResultView {
    fun showTickets(tickets: List<LottoTicket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun showStatistics(matchResult: LottoMatchResult) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${LottoConstants.PRIZE_MATCH_3}원)- ${matchResult.getMatchCount(3)}개")
        println("4개 일치 (${LottoConstants.PRIZE_MATCH_4}원)- ${matchResult.getMatchCount(4)}개")
        println("5개 일치 (${LottoConstants.PRIZE_MATCH_5}원)- ${matchResult.getMatchCount(5)}개")
        println("6개 일치 (${LottoConstants.PRIZE_MATCH_6}원)- ${matchResult.getMatchCount(6)}개")
    }

    fun showReturnRate(returnRate: Double) {
        println("총 수익률은 ${String.format("%.2f", returnRate)}입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
