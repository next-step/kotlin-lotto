package service

import model.LottoPrize
import model.PrizeEarn

class CalculateService(prizeList: List<Pair<Int, Int>>) {
    private val prizeStatListMutable = mutableListOf<PrizeEarn>()

    val prizeStatList: List<PrizeEarn>
        get() = prizeStatListMutable.toList()

    init {
        for (lottoPrize in LottoPrize.values()) {
            prizeList.firstOrNull { lottoPrize.isEqualGrade(it.first) }?.let { pair ->
                prizeStatListMutable.add(PrizeEarn(lottoPrize, pair.second))
            }
        }
    }

    fun getEarningRate(purchaseAmount: Int): Double {
        return (prizeStatList.sumBy { it.totalPrizeMoney }.toDouble() / purchaseAmount)
    }
}
