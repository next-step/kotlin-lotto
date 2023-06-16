package lottery.domain.lottery

import lottery.domain.Money
import lottery.domain.Rank
import lottery.domain.Rank.Companion.fillMissRankWithDefault
import lottery.domain.lottery.Lottery.Companion.LOTTERY_COST

class Lotteries(
    val values: MutableList<Lottery>
) {
    fun compareWinningLottery(winningLottery: WinningLottery) =
        values.map { winningLottery.compareLottery(it) }
            .groupingBy { it }
            .eachCount()
            .fillMissRankWithDefault()
            .toSortedMap(Rank.comparator)

    fun addLotteries(lotteries: List<Lottery>) = values.addAll(lotteries)

    fun cost(): Money = LOTTERY_COST.times(values.size)

    companion object {
        fun init() = Lotteries(mutableListOf())
    }
}
