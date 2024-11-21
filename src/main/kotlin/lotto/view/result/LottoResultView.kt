package lotto.view.result

import lotto.domain.LottoResults

object LottoResultView {
    fun print(results: LottoResults) {
        val sb = StringBuilder()
        printTitle(sb)
        printWinCountInfo(sb, results)
        printProfitRate(sb, results)
        println(sb.toString())
    }

    private fun printTitle(sb: StringBuilder) {
        sb.append("당첨 통계\n")
        sb.append("---------\n")
    }

    private fun printWinCountInfo(
        sb: StringBuilder,
        results: LottoResults,
    ) {
        results.getWinResult().forEach {
            sb.append("${it.rank.matchCount}개 일치 (${it.rank.reward}원) - ${it.count}개\n")
        }
    }

    private fun printProfitRate(
        sb: StringBuilder,
        results: LottoResults,
    ) {
        val profitOrLoss = if (results.isProfit()) "이익" else "손해"
        sb.append("총 수익률은 ${results.getProfitRate()}입니다. 기준이 ${LottoResults.MARGIN_VALUE}이기 때문에 결과적으로 ${profitOrLoss}라는 의미임.")
    }
}
