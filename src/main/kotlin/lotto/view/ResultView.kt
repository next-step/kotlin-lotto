package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoResults
import lotto.domain.LottoResults.LottoResult

object ResultView {
    fun printPurchaseAmount(purchaseAmount: Int) {
        println("${purchaseAmount}개를 구매했습니다.")
    }

    fun printLottoList(lottoList: List<Lotto>) {
        lottoList.forEach { println("[$it]") }
        println()
    }

    fun printResult(lottoResults: LottoResults) {
        printResultHeader()
        printLottoResults(lottoResults)
        printRateOfReturn(lottoResults)
    }

    private fun printResultHeader() {
        println("당첨 통계")
        println("---------")
    }

    private fun printLottoResults(lottoResults: LottoResults) {
        lottoResults.getWiningResults()
            .forEach(::printLottoResult)
    }

    private fun printLottoResult(lottoResult: LottoResult) {
        println(
            "${lottoResult.rank.matchCount}개 일치 " +
                "${lottoResult.rank.winningMoney} - ${lottoResult.count}개",
        )
    }

    private fun printRateOfReturn(lottoResults: LottoResults) {
        println(
            "총 수익률은 ${lottoResults.calculateRateOfReturn()}입니다. " +
                "(기준이 1이기 때문에 결과적으로 ${profitOrLoss(lottoResults.isProfitable())}라는 의미임.)",
        )
    }

    private fun profitOrLoss(isProfitable: Boolean) = if (isProfitable) "이익" else "손해"
}
