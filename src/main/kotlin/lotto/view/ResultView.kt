package lotto.view

import lotto.domain.LottoList
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.Rank

object ResultView {
    private const val RESULT_SUMMARY = "당첨 통계"
    private const val LOTTO_LIST_COUNT = "수동으로 %s장, 자동으로 %s개를 구매했습니다."

    fun printLottoResult(lottoResult: LottoResult) {
        println(RESULT_SUMMARY)
        printLineBreak()
        printResultForMatchingCounts(lottoResult)
        printRateOfReturn(lottoResult)
    }

    fun printLottos(lottoList: LottoList, manualLottoCount: Int) {
        println(LOTTO_LIST_COUNT.format(manualLottoCount, lottoList.size() - manualLottoCount))
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
            printResultPerRank(rank, lottoResult)
        }
    }

    private fun printResultPerRank(rank: Rank, lottoResult: LottoResult) {
        val bonusString = ", 보너스 볼 일치"
        println(
            "${rank.matchCount}개 일치" +
                (if (rank == Rank.SECOND) bonusString else "") +
                " (${rank.prize}원)- ${lottoResult.result[rank] ?: 0}개"
        )
    }

    private fun printLineBreak() {
        println("----------")
    }
}
