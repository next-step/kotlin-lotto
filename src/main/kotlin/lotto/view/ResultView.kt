package lotto.view

import lotto.domain.LottoResult

object ResultView {
    private const val RESULT_SUMMARY = "당첨 통계"

    fun printLottoResult(lottoResult: LottoResult) {
        println(RESULT_SUMMARY)
        printLineBreak()
        (3..6).map {
            printResultForMatching(it, lottoResult)
        }
    }

    private fun printResultForMatching(matching: Int, lottoResult: LottoResult) {
        println("${matching}개 일치 (${LottoResult.prizeMoneyMap[matching]}원)- ${lottoResult.result[matching]?.lottos?.size ?: 0}개")
    }

    private fun printLineBreak() {
        println("----------")
    }
}
