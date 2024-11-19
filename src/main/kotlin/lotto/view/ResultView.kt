package lotto.view

import lotto.domain.LottoResultAnalyzer

object ResultView {
    fun printPurchaseAmount(purchaseAmount: Int) {
        println("${purchaseAmount}개를 구매했습니다.")
    }

    fun printLottoList(lottoList: List<List<Int>>) {
        for (lotto in lottoList) {
            val numbers = lotto.joinToString(", ")
            println("[$numbers]")
        }
        println()
    }

    fun printResult(lottoResult: LottoResultAnalyzer.LottoResult) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${lottoResult.fourthCount}개")
        println("4개 일치 (50000원)- ${lottoResult.thirdCount}개")
        println("5개 일치 (1500000원)- ${lottoResult.secondCount}개")
        println("6개 일치 (2000000000원)- ${lottoResult.firstCount}개")
        printRateOfReturn(lottoResult)
    }

    private fun printRateOfReturn(lottoResult: LottoResultAnalyzer.LottoResult) {
        val purchaseAmount = lottoResult.totalLottoCount * 1_000
        val earningAmount = lottoResult.fourthCount * 5_000 +
            lottoResult.thirdCount * 50_000 +
            lottoResult.secondCount * 1_500_000 +
            lottoResult.firstCount * 2_000_000_000
        val rateOfReturn = earningAmount.toDouble() / purchaseAmount
        val isProfitable = rateOfReturn > 1.0

        println(
            "총 수익률은 ${rateOfReturn}입니다. (기준이 1이기 때문에 결과적으로 ${isProfitOrLoss(isProfitable)}라는 의미임.)",
        )
    }

    private fun isProfitOrLoss(isProfitable: Boolean) = if (isProfitable) "이익" else "손해"
}
