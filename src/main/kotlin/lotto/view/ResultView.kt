package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoRank

object ResultView {
    fun showPurchaseLottoCount(count: Int) {
        println("$count 개를 구매했습니다.")
    }

    fun showLotto(lottoNumber: List<LottoNumber>) {
        println(lottoNumber)
    }

    fun showWinningStatistics() {
        println("당첨 통계")
        println("--------")
    }

    fun showRankCount(lottoRanks: Map<LottoRank, Int>) {
        LottoRank.values().forEach {
            println(
                "${it.matchCount}개 일치 ${if (it == LottoRank.SECOND) ", 보너스 볼 일치" else ""} (${it.winningPrice}원) - ${lottoRanks[it] ?: 0} 개"
            )
        }
    }

    fun showProfitRate(rate: Float) {
        println("총 수익률은 $rate 입니다.")
    }
}
