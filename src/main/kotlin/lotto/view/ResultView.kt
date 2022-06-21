package lotto.view

import lotto.domain.EarnedRate
import lotto.domain.LottoMatchResult
import lotto.domain.LottoTickets
import lotto.domain.Rank.SECOND

object ResultView {
    fun showLottoInfo(lottoTickets: LottoTickets) {
        val lottoCount = lottoTickets.lottoTickets.size
        println("${lottoCount}개를 구매했습니다.")
        lottoTickets.lottoTickets.forEach { lotto ->
            println(lotto.lottoNumbers.joinToString(prefix = "[", postfix = "]"))
        }
    }

    fun showMatchResult(lottoMatchResult: LottoMatchResult, earnedRate: EarnedRate) {
        println("\n당첨 통계")
        println("---------")
        lottoMatchResult.matchResult.getResult()
            .forEach { (rank, count) ->
                when (rank) {
                    SECOND -> println("${rank.numOfMatch}개 일치, 보너스 볼 일치(${rank.winningMoney}원) - ${count.count}개")
                    else -> println("${rank.numOfMatch}개 일치 (${rank.winningMoney}원) - ${count.count}개")
                }
            }
        println("총 수익률은 ${String.format("%.3f", earnedRate.rate).dropLast(1)}입니다.")
    }
}
