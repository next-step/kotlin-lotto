package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoResults
import lotto.domain.LottoResults.LottoResult

object ResultView {
    fun printLottoList(lottoList: List<Lotto>, manualLottoNumberCount: Int) {
        println(
            "수동으로 ${manualLottoNumberCount}장, " +
                "자동으로 ${lottoList.size - manualLottoNumberCount}장을 구매했습니다.",
        )
        printNumbers(lottoList)
        println()
    }

    private fun printNumbers(lottoList: List<Lotto>) {
        lottoList.forEach {
            println(
                "[${it.lottoNumbers.joinToString(", ") { it.value.toString() }}]",
            )
        }
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
                "(기준이 1이기 때문에 결과적으로 ${profitOrLoss(lottoResults.isProfitable)}라는 의미임.)",
        )
    }

    private fun profitOrLoss(isProfitable: Boolean) = if (isProfitable) "이익" else "손해"
}
