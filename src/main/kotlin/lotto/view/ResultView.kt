package lotto.view

import lotto.domain.LottoReward
import lotto.domain.LottoTicket
import lotto.dto.LottoMatchResult

object ResultView {
    fun showTickets(tickets: List<LottoTicket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun showReturnRate(returnRate: Double) {
        println("총 수익률은 ${String.format("%.2f", returnRate)}입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    fun showStatistics(matchResult: LottoMatchResult) {
        println("당첨 통계")
        println("---------")
        (3..6).forEach { matchCount ->
            val count = matchResult.getMatchCount(matchCount)
            val reward = LottoReward.getRewardByMatchCount(matchCount)
            println("${matchCount}개 일치 (${reward}원)- ${count}개")
        }
    }
}
