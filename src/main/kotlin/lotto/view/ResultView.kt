package lotto.view

import lotto.domain.lotto.LottoTickets
import lotto.domain.lotto.ManualLottoTotal
import lotto.domain.matcher.EarnedRate
import lotto.domain.matcher.LottoMatchResult
import lotto.domain.rank.Rank.SECOND

object ResultView {
    fun showLottoInfo(lottoTickets: LottoTickets, manualLottoTotal: ManualLottoTotal) {
        val lottoCount = lottoTickets.lottoTickets.size
        val manualCount = manualLottoTotal.value
        println("수동으로 ${manualCount}장, 자동으로 ${lottoCount - manualCount}개를 구매했습니다.")
        lottoTickets.lottoTickets.forEach { lotto ->
            println(lotto.lottoNumbers.toInts())
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
