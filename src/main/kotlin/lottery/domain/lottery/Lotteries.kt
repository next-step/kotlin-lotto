package lottery.domain.lottery

import lottery.domain.Money
import lottery.domain.lottery.Lottery.Companion.LOTTERY_COST
import lottery.domain.rank.Rank
import lottery.domain.rank.Rank.Companion.fillMissRankWithDefault

class Lotteries(
    val values: MutableList<Lottery>,
) {
    fun compareWinningLottery(winningLottery: WinningLottery) =
        values.map { winningLottery.rankConfirm(it) }
            .groupingBy { it }
            .eachCount()
            .fillMissRankWithDefault()
            .toSortedMap(Rank.comparator)

    fun addLotteries(lotteries: List<Lottery>) = values.addAll(lotteries)

    fun cost(): Money = LOTTERY_COST.times(values.size)

    companion object {
        fun init() = Lotteries(mutableListOf())

        fun from(values: List<List<String>>) = Lotteries(values.map { Lottery.from(it) }.toMutableList())
    }
}
