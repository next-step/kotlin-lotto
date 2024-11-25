package lottery.view

import lottery.domain.DrawResult
import lottery.domain.Lottery
import lottery.domain.Money
import lottery.domain.RankReward
import lottery.domain.Ticket

object ResultView {
    fun printTicketCount(tickets: List<Ticket>) {
        println("${tickets.size}개를 구매했습니다.")
    }

    fun printLotteries(lotteries: List<Lottery>) {
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
            println("$rank- ${drawResult.findLotteryCount(rank)}개")
        }
        println("총 수익률은 ${drawResult.getTotalReward().divideBy(purchaseAmount)}입니다.")
    }
}
