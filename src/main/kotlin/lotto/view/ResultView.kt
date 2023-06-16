package lotto.view

import lotto.LottoGame
import lotto.LottoGameStatistics
import lotto.LottoNumbers
import lotto.Rank

object ResultView {
    fun printAllLottoNumbers(lottoGame: LottoGame) {
        lottoGame.lottoNumbers.forEach { printLottoNumbers(it) }
    }

    fun printLottoResultStatistics(statistics: LottoGameStatistics) {
        println("당첨 통계")
        println("---------")

        val sortedMap = statistics.result.toSortedMap(compareByDescending { statistics.result[it] })
        sortedMap.forEach { printLottoResult(it.key, it.value) }

        println("총 수익률은 ${statistics.roi}입니다.")
    }

    fun printLottoResult(rank: Rank, count: Int) {
        if (rank != Rank.LOSE) {
            println("${rank.matchedCount}개 일치 (${rank.reward}원) - ${count}개")
        }
    }

    private fun printLottoNumbers(lottoNumbers: LottoNumbers) {
        println("[${lottoNumbers.numbers.map { it.number }.joinToString(", ")}]")
    }
}