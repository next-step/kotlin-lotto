package lotto.view

import lotto.response.LottoLinesResponse
import lotto.response.LottoRankResponse

class OutputView {
    fun printPurchaseCount(purchaseCount: Int) {
        println("${purchaseCount}개를 구매했습니다.")
    }

    fun printPurchaseLottoLines(lottoLinesResponse: LottoLinesResponse) {
        val result = lottoLinesResponse.toFormattedString()
        println(result)
    }

    fun printGameResult(gameResult: List<LottoRankResponse>) {
        val result =
            buildString {
                appendLine("\n당첨 통계")
                appendLine("---------")
                gameResult.forEach { appendLine(it.toFormattedString()) }
            }
        println(result)
    }

    fun printLottoProfitRate(lottoProfitRateValue: Double) {
        val result =
            buildString {
                append("총 수익률은 ${lottoProfitRateValue}입니다.")
                addAdditionalExplan(lottoProfitRateValue)
            }
        println(result)
    }

    private fun StringBuilder.addAdditionalExplan(lottoProfitRateValue: Double) {
        if (lottoProfitRateValue <= 1.0) {
            appendLine("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
            return
        }
        appendLine()
        return
    }
}
