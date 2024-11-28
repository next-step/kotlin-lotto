package lotto.view

import lotto.domain.AutoTicket
import lotto.domain.DrawResult
import lotto.domain.Lotto
import lotto.domain.Money
import lotto.domain.RankReward

object ResultView {
    fun printTicketCount(tickets: List<AutoTicket>) {
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
            val bonusText = if (rank in RankReward.needMatchBonusRanks) ", 보너스 볼 일치" else ""
            val rankText = "${rank.matchedCount}개 일치$bonusText (${rank.money})"
            println("$rankText- ${drawResult.getLottoCount(rank)}개")
        }
        println("총 수익률은 ${drawResult.getProfitRate(purchaseAmount)}입니다.")
    }
}
