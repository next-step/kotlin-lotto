package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.LottoResult

class ResultView {

    //TODO :
    fun displayPurchasedLotto(lottoList: List<Lotto>) {
        println("${lottoList.size} 개를 구매했습니다.")
        lottoList.forEach { println(it.toString()) }
        println()
    }

    fun displayResult(result: LottoResult) {
        println("당첨 통계")
        println("---------")
        LottoRank.ranks().forEach { printRankInfo(it, result) }
        printResultRate(result)
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

    private fun printResultRate(result: LottoResult) {
        val rate = result.rateOfReturn
        val message = if (rate < 1) LOSS else GAIN
        println("총 수익률은 ${String.format("%.2f", rate)}" + "입니다. " + message)
    }

    companion object {
        private const val LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        private const val GAIN = "(기준이 1이기 때문에 결과적으로 이득이는 의미임)"
    }
}
