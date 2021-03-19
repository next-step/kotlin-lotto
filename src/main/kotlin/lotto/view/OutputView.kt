package lotto.view

import lotto.domain.LottoBasket
import lotto.domain.LottoPrize
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
        LottoPrize.values().reversed().forEach {
            if (it == LottoPrize.NOT_MATCH) return@forEach
            if (it == LottoPrize.FIVE_BONUS_MATCH)
                println("${it.value}개 일치, 보너스 볼 일치(${it.price}원)- ${statistics[it] ?: 0}개")
            else println("${it.value}개 일치 (${it.price}원)- ${statistics[it] ?: 0}개")
        }
    }

    fun showEarningRatio(earningRate: Double) {
        println("총 수익률은 ${earningRate}입니다.")
    }
}
