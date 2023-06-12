package lottery

import lottery.Rank.Companion.fillMissRankWithDefault

class Lotteries(
    val values: List<Lottery>
) {
    fun compareWinningLottery(winningLottery: Lottery): Map<Rank, Int> =
        values.map { winningLottery.compareWinningLottery(it) }
            .groupingBy { it }
            .eachCount()
            .fillMissRankWithDefault()
}
