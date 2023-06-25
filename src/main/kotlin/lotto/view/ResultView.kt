package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.LottoResult

class ResultView {

    fun displayPurchasedLotto(lottoList: List<Lotto>) {
        println("${lottoList.size} 개를 구매했습니다.")
        lottoList.forEach { println(it.toString()) }
        println()
    }

    fun displayResult(result: LottoResult) {
        println("당첨 통계")
        println("---------")
        LottoRank.ranks().forEach { printRankInfo(it, result) }
        println("총 수익률은 ${String.format("%.2f", result.rateOfReturn)}" + "입니다. " + result.message)
    }

    private fun printRankInfo(rank: LottoRank, result: LottoResult) {
        if (rank == LottoRank.NONE) return

        val cnt = result.rankCntMap.getOrDefault(rank, 0)

        if (rank == LottoRank.SECOND) {
            println("${rank.numOfMatch}" + "개 일치, 보너스 볼 일치 (${rank.winningMoney}" + "원)- $cnt" + "개\n")
            return
        }
        println("${rank.numOfMatch}" + "개 일치 (${rank.winningMoney}" + "원)- $cnt" + "개\n")

    }
}
