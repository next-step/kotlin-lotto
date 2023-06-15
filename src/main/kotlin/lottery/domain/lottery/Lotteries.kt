package lottery.domain.lottery

import lottery.domain.Rank
import lottery.domain.Rank.Companion.fillMissRankWithDefault
import lottery.domain.lottery.Lottery.Companion.LOTTERY_COST
import java.math.BigDecimal

class Lotteries(
    val values: MutableList<Lottery>
) {
    fun compareWinningLottery(winningLottery: Lottery) =
        values.map { winningLottery.compareWinningLottery(it) }
            .groupingBy { it }
            .eachCount()
            .fillMissRankWithDefault()
            .toSortedMap(Rank.comparator)

    fun addLotteries(lotteries: List<Lottery>) = values.addAll(lotteries)

    fun cost() = BigDecimal(LOTTERY_COST.times(values.size).value)

    companion object {
        fun init() = Lotteries(mutableListOf())
    }
}
