package lotto.view

import lotto.domain.LottoRank

object ResultView {
    fun showPurchaseLottoCount(count: Int) {
        println("$count 개를 구매했습니다.")
    }

    fun showLotto(lottoNumber: String) {
        println("[$lottoNumber]")
    }

    fun showWinningStatistics() {
        println("당첨 통계")
        println("--------")
    }

    fun showRankCount(count: Int, rank: LottoRank) {
        println("${rank.matchCount}개 일치 (${rank.winningPrice}원) - $count 개")
    }

    fun showProfitRate(rate: Float) {
        println("총 수익률은 $rate 입니다.")
    }
}
