package lotto.view

import lotto.controller.dto.LottoData
import lotto.domain.Rank

object ResultView {
    fun printPurchasedLottoNumber(lottoNumber: Int) {
        println("${lottoNumber}개를 구매했습니다.")
    }

    fun printLottos(lottoDatas: List<LottoData>) {
        lottoDatas.forEach { println(it.lottoNumbers) }
        println()
    }

    fun printStatistics(statics: Map<Rank, Int>) {
        println("당첨 통계")
        println("---------")
        Rank.values().sortedDescending()
            .forEach { printStatisticsByRank(it, statics) }
    }

    private fun printStatisticsByRank(rank: Rank, static: Map<Rank, Int>) {
        if (rank === Rank.NONE) {
            return
        }

        if (rank !== Rank.SECOND) {
            println("${rank.correctNumber}개 일치 (${rank.winningMoney}원)- ${static[rank] ?: 0}개")
            return
        }

        println("${rank.correctNumber}개 일치, 보너스 볼 일치(${rank.winningMoney}원)- ${static[rank] ?: 0}개")
    }

    fun printEarningRate(earningRate: Double) {
        println("총 수익률은 ${earningRate}입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
