package lotto.view

import lotto.vo.LottoBasket
import lotto.domain.LottoPrize
import lotto.vo.Winners

object OutputView {
    fun showPurchaseStatus(lottos: LottoBasket) {
        println("${lottos.lottos.size}개를 구매했습니다.")
        lottos.lottos.forEach {
            println(it)
        }
    }

    fun showWinningStatus(winners: Winners) {
        val winnerCount = winners.winners.groupingBy { it }.eachCount()
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${LottoPrize.THREE_MATCH})- ${winnerCount[LottoPrize.THREE_MATCH] ?: 0}개")
        println("4개 일치 (${LottoPrize.FOUR_MATCH})- ${winnerCount[LottoPrize.FOUR_MATCH] ?: 0}개")
        println("5개 일치 (${LottoPrize.FIVE_MATCH})- ${winnerCount[LottoPrize.FIVE_MATCH] ?: 0}개")
        println("6개 일치 (${LottoPrize.SIX_MATCH})- ${winnerCount[LottoPrize.SIX_MATCH] ?: 0}개")
    }

    fun showEarningRatio(earningRate: Double) {
        println("총 수익률은 ${earningRate}입니다.")
    }
}
