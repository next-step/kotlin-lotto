package lotto.view

import lotto.domain.LottoRank

class OutputView {
    fun printPurchaseCount(purchaseCount: Int) {
        println("${purchaseCount}개를 구매했습니다.")
    }

    fun printPurchaseLottoLines(lineValues: List<List<Int>>) {
        lineValues.forEach {
            println(it.joinToString(", ", "[", "]"))
        }
    }

    fun printGameResult(gameResult: List<Pair<LottoRank, Int>>) {
        println("\n당첨 통계")
        println("---------")
        gameResult.forEach { (rank, count) ->
            println("${rank.description} (${rank.prize}원)- ${count}개")
        }
    }

    fun printLottoProfitRate(lottoProfitRateValue: Double) {
        print("총 수익률은 ${lottoProfitRateValue}입니다.")
        if (lottoProfitRateValue <= 1.0) {
            println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        } else {
            println()
        }
    }
}
