package lotto.view

import lotto.domain.LottoList
import lotto.domain.LottoResult

object ResultView {
    private const val RESULT_SUMMARY = "당첨 통계"

    fun printLottoResult(lottoResult: LottoResult) {
        println(RESULT_SUMMARY)
        printLineBreak()
        printResultForMatchingCounts(lottoResult)
        printRateOfReturn(lottoResult)
    }

    fun printLottos(lottoList: LottoList) {
        println("${lottoList.size()}개 구매했습니다.")
        lottoList.lottos.forEach { lotto ->
            println(lotto.lottoNumbers.numbers)
        }
    }

    private fun printRateOfReturn(lottoResult: LottoResult) {
        println("총 수익률은 ${lottoResult.getRateOfReturn()}입니다.")
    }

    private fun printResultForMatchingCounts(lottoResult: LottoResult) {
        (3..6).map { matchingCount ->
            println("${matchingCount}개 일치 (${LottoResult.prizeMoneyMap[matchingCount]}원)- ${lottoResult.result[matchingCount]?.size() ?: 0}개")
        }
    }

    private fun printLineBreak() {
        println("----------")
    }
}
