package lottery.view

import lottery.domain.Lottery
import lottery.domain.Rank
import lottery.domain.RankCounts
import lottery.domain.RankPrinter

object ResultView {
    fun printCountOfBuyLottery(price: Int) {
        println("${price}개를 구매하였습니다.")
    }
    fun printProfit(profit: String) {
        print("총 수익률은 ${profit}입니다.")
    }

    fun printLotteriesNumbers(lotteries: List<Lottery>) {
        lotteries.map { println(it.toString()) }
    }

    fun printMatchNumbers(match: RankCounts) {
        Rank.values().forEach { printMatchNumber(match.retrieve(it), it) }
    }

    private fun printMatchNumber(matchCount: Int, rank: Rank) {
        println("${RankPrinter.valueOf(rank).content} (${rank.price}원)- $matchCount")
    }
}
