package lotto.view

import lotto.domain.Lottos
import lotto.domain.PrizeMoney
import java.math.BigDecimal

const val NEED_MORE_PAYMENT = "1000원 이상의 금액이 필요합니다. 다시 시도해주세요."

object ResultView {

    fun showPurchaseAmounts(amounts: Int) {
        println("${amounts}개를 구매했습니다.")
    }

    fun showLottosDetail(lottos: Lottos) {
        println(lottos)
    }

    fun showResults(result: Map<PrizeMoney, Int>) {
        println("\n당첨 통계\n---------")
        printResult(result)
    }

    fun showProfitRatio(ratio: BigDecimal) {
        print("총 수익률은 ${ratio}입니다.(기준이 1이기 때문에 결과적으로 ")

        if (BigDecimal.ONE > ratio) println("손해라는 의미임)")
        else println("이득이라는 의미임)")
    }

    private fun printResult(result: Map<PrizeMoney, Int>) {
        result.forEach { (key, value) ->
            println("${key.condition}개 일치 (${key.money}원)- ${value}개")
        }
    }

    fun showTryAgain() {
        println(NEED_MORE_PAYMENT)
    }
}
