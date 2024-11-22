package lotto.view

import lotto.domain.LottoRank

class OutputView {
    fun printPurchaseCount(purchaseCount: Int) {
        println("${purchaseCount}개를 구매했습니다.")
    }

    fun printPurchaseLottoLines(lineValues: List<List<Int>>) {
        val result =
            buildString {
                lineValues.forEach { line ->
                    appendLine(line.joinToString(", ", "[", "]"))
                }
            }
        println(result)
    }

    fun printGameResult(gameResult: List<Pair<LottoRank, Int>>) {
        val result =
            buildString {
                appendLine("\n당첨 통계")
                appendLine("---------")
                gameResult.forEach { (rank, count) ->
                    appendLine("${rank.description} (${rank.prize}원)- ${count}개")
                }
            }
        println(result)
    }

    fun printLottoProfitRate(lottoProfitRateValue: Double) {
        val result =
            buildString {
                append("총 수익률은 ${lottoProfitRateValue}입니다.")
                if (lottoProfitRateValue <= 1.0) {
                    appendLine("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
                } else {
                    appendLine()
                }
            }
        println(result)
    }
}
