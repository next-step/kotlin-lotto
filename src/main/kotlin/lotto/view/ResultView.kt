package lotto.view

import lotto.LottoGame
import lotto.LottoGameStatistics
import lotto.LottoNumbers
import lotto.Rank

object ResultView {
    fun printGameCount(gameCount: Int) {
        println("${gameCount}개를 구매했습니다.")
    }

    fun printAllLottoNumbers(lottoNumbers: List<LottoNumbers>) {
        lottoNumbers.forEach { printLottoNumbers(it) }
    }

    fun printLottoResultStatistics(statistics: LottoGameStatistics) {
        println("당첨 통계")
        println("---------")

        Rank.values()
            .sortedWith(compareBy(Rank::matchedCount, Rank::reward))
            .forEach { printLottoResult(it, statistics.countByRank(it)) }

        println("총 수익률은 ${statistics.roi}입니다.")
    }

    private fun printLottoResult(rank: Rank, count: Int) {
        Rank.values()

        if (rank == Rank.SECOND) {
            println("${rank.matchedCount}개 일치, 보너스 볼 일치 (${rank.reward}원) - ${count}개")
        } else if (rank != Rank.LOSE) {
            println("${rank.matchedCount}개 일치 (${rank.reward}원) - ${count}개")
        }
    }

    private fun printLottoNumbers(lottoNumbers: LottoNumbers) {
        println("[${lottoNumbers.numbers.map { it.number }.joinToString(", ")}]")
    }
}