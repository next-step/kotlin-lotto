package lotto.view

import lotto.domain.LottoPrize
import lotto.domain.LottoBasket
import lotto.vo.Statistics

object OutputView {
    fun showPurchaseStatus(lottos: LottoBasket) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it)
        }
    }

    fun showWinningStatus(statistics: Statistics) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${LottoPrize.THREE_MATCH})- ${statistics.stats[LottoPrize.THREE_MATCH] ?: 0}개")
        println("4개 일치 (${LottoPrize.FOUR_MATCH})- ${statistics.stats[LottoPrize.FOUR_MATCH] ?: 0}개")
        println("5개 일치 (${LottoPrize.FIVE_MATCH})- ${statistics.stats[LottoPrize.FIVE_MATCH] ?: 0}개")
        println("6개 일치 (${LottoPrize.SIX_MATCH})- ${statistics.stats[LottoPrize.SIX_MATCH] ?: 0}개")
    }

    fun showEarningRatio(earningRate: Double) {
        println("총 수익률은 ${earningRate}입니다.")
    }
}
