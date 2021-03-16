package lottery.view

import lottery.domain.Lottery
import lottery.domain.Rank

object ResultView {
    private const val DEFAULT_MATCH_COUNT_VALUE = 0

    fun printLotteriesNumbers(lotteries: List<Lottery>) {
        lotteries.map { println(it.toString()) }
    }

    fun printMatchNumbers(start: Int, end: Int, match: Map<Int, Int>) {
        (start..end).forEach { printMatchNumber(match.getOrDefault(it, DEFAULT_MATCH_COUNT_VALUE), Rank.valueOf(it)) }
    }

    private fun printMatchNumber(matchCount: Int, rank: Rank) {
        println("${rank.matchCount}개 일치 (${rank.price}원)- $matchCount")
    }
}
