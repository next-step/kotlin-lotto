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
        println("3개 일치 (${LottoRank.FOURTH.winningPrice}원) - ${lottoRanks[LottoRank.FOURTH] ?: 0} 개")
        println("4개 일치 (${LottoRank.THIRD.winningPrice}원) - ${lottoRanks[LottoRank.THIRD] ?: 0} 개")
        println("5개 일치 (${LottoRank.SECOND.winningPrice}원) - ${lottoRanks[LottoRank.SECOND] ?: 0} 개")
        println("6개 일치 (${LottoRank.FIRST.winningPrice}원) - ${lottoRanks[LottoRank.FIRST] ?: 0} 개")
    }

    fun showProfitRate(rate: Float) {
        println("총 수익률은 $rate 입니다.")
    }
}
