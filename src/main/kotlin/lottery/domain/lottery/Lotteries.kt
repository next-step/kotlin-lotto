package lottery.domain.lottery

import lottery.domain.Rank
import lottery.domain.Rank.Companion.fillMissRankWithDefault

class Lotteries(
    val values: List<Lottery>
) : List<Lottery> by values {
    fun compareWinningLottery(winningLottery: Lottery) =
        values.map { winningLottery.compareWinningLottery(it) }
            .groupingBy { it }
            .eachCount()
            .fillMissRankWithDefault()
            .toSortedMap(Rank.comparator)

    companion object {
        fun List<Lottery>.toLotteries() = Lotteries(this)
    }
}
