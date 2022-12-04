package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinAmount

class ResultView {

    companion object {
        fun printPurchaseLotto(lottos: List<Lotto>) {
            println("${lottos.size}개를 구매했습니다")
            println(lottos.joinToString { "\n" })
        }

        fun printStatistics(statistic: Map<Int, MutableList<Lotto>>, amount: Int)  {
            println("당첨 통계")
            println("---------")

            var totalWinAmount: Long = 0
            for(count in statistic.keys) {
                totalWinAmount += WinAmount.find(count)
                println("${count}개 일치 (${WinAmount.find(count)}원) - ${statistic[count]?.size}개")
            }

            val rate = (totalWinAmount/amount) * 100
            println("총 수익률은 ${rate}입니다.")
        }
    }
}