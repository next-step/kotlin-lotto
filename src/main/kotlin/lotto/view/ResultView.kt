package lotto.view

import lotto.domain.LottoList
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.Rank

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
            println(lotto.lottoNumbers.map(LottoNumber::number))
        }
    }

    private fun printRateOfReturn(lottoResult: LottoResult) {
        println("총 수익률은 ${lottoResult.getRateOfReturn()}입니다.")
    }

    private fun printResultForMatchingCounts(lottoResult: LottoResult) {
        Rank.values().forEachIndexed { index, rank ->
            if (index == 0) return@forEachIndexed
            println("${rank.matchCount}개 일치 (${rank.prize}원)- ${lottoResult.result[rank] ?: 0}개")
        }
    }

    private fun printLineBreak() {
        println("----------")
    }
}
