package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoPurchaseAmount
import lotto.domain.enums.LottoCompensationStrategy
import java.math.BigDecimal

object ResultView {
    fun printLottoPurchaseAmount(purchaseAmount: LottoPurchaseAmount) {
        val totalLottoCount = purchaseAmount.calculateLottoCount()
        println("${totalLottoCount}개를 구매했습니다.")
    }

    fun printLotteries(lotteries: List<Lotto>) {
        lotteries.forEach {
            println(it.values)
        }
        println()
    }

    fun printLottoResult(lottoResults: Map<LottoCompensationStrategy, Int>) {
        val title = """
            
            당첨 통계
            ---------
        """.trimIndent()
        println(title)
        lottoResults.forEach { (strategy, count) ->
            println("${strategy.correctCount}개 일치 (${strategy.compensation}${strategy.unit})- ${count}개")
        }
    }

    fun print수익률(수익률: BigDecimal) {
        println("총 수익률은 ${수익률.setScale(2)}입니다.")
    }
}
