package lotto.view

import lotto.domain.LottoTicket
import lotto.dto.LottoMatchResult
import lotto.enum.Rank

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
        showMatchCountsStatistics(matchResult)
        showBonusMatchStatistics(matchResult)
    }

    private fun showMatchCountsStatistics(matchResult: LottoMatchResult) {
        (3..6).forEach { matchCount ->
            val count = matchResult.getMatchCount(matchCount)
            val reward = Rank.valueOf(matchCount, matchCount == 5 && matchResult.bonusMatchCount > 0).winningMoney
            println("$matchCount 개 일치 (${reward}원)- ${count}개")
        }
    }

    private fun showBonusMatchStatistics(matchResult: LottoMatchResult) {
        // bonusMatchCount는 이미 직접 접근 가능하므로 별도의 메서드 호출이 필요하지 않음
        if (matchResult.bonusMatchCount > 0) {
            val bonusReward = Rank.SECOND.winningMoney
            println("5개 일치, 보너스 볼 일치(${bonusReward}원) - ${matchResult.bonusMatchCount}개")
        }
    }
}
