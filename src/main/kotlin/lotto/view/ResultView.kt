package lotto.view

import lotto.domain.DrawResult
import lotto.domain.Lotto
import lotto.domain.Money
import lotto.domain.RankReward
import lotto.domain.RankReward.MISS
import lotto.domain.Ticket

object ResultView {
    fun printTicketCount(tickets: List<Ticket>) {
        println("${tickets.size}개를 구매했습니다.")
    }

    fun printLotteries(lotteries: List<Lotto>) {
        lotteries.forEach {
            println(it)
        }
        println()
    }

    fun printStatistic(
        purchaseAmount: Money,
        drawResult: DrawResult,
    ) {
        println()
        println("당첨 통계")
        println("---------")
        RankReward.sortLowToHighByRank().forEach { rank ->
            if (rank == MISS) return@forEach
            println("$rank- ${drawResult.getLottoCount(rank)}개")
        }
        println("총 수익률은 ${drawResult.getProfitRate(purchaseAmount)}입니다.")
    }
}
