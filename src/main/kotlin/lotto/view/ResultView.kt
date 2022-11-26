package lotto.view

import kotlin.math.floor

object ResultView {
    fun printNumberOfPurchases(amount: Int) {
        println("$amount 개를 구매했습니다.")
    }

    fun printRewardsStatistics() {
        println("당첨 통계")
        println("---------")
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        val value = floor(rateOfReturn * 100) / 100
        print("총 수익률은 $value 입니다.")
        if (value < 1.0) println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
