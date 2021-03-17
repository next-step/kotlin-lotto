package lottery.view

import lottery.domain.Lottery
import lottery.domain.Rank
import lottery.domain.RankCounts

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

    fun printMatchNumbers(start: Int, end: Int, match: RankCounts) {
        (start..end).forEach { printMatchNumber(match.retrieve(Rank.valueOf(it)), Rank.valueOf(it)) }
    }

    private fun printMatchNumber(matchCount: Int, rank: Rank) {
        println("${rank.matchCount}개 일치 (${rank.price}원)- $matchCount")
    }
}
