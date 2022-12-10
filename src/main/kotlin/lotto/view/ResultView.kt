package lotto.view

import lotto.domain.*

class ResultView {

    companion object {
        fun printPurchaseLotto(manualLottos: List<Lotto>, autoLottos: List<Lotto>) {
            println("수동으로 ${manualLottos.size}장, 자동으로 ${autoLottos.size}장을 구매했습니다")
            println(manualLottos.joinToString { "\n" })
            println(autoLottos.joinToString { "\n" })
        }

        fun printStatistics(statistic: Statistics, amount: Amount)  {
            println("당첨 통계")
            println("---------")

            var winMount: Long = 0
            for(rank in Rank.values()) {
                if(rank == Rank.MISS) continue
                winMount += rank.amount
                println("${rank.count}개 일치 (${rank.amount}원) - ${statistic.from(rank).size}개")
            }

            val totalWinAmount = Amount(winMount)
            val rate = Rate(totalWinAmount, amount).toReturn()
            println("총 수익률은 ${rate}입니다.")
        }
    }
}