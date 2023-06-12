package lottery.domain

import lottery.domain.lottery.Lotteries
import lottery.domain.lottery.Lottery

class Wallet(
    val usedMoney: Int,
    val purchasedLotteries: Lotteries
) {
    fun calculateLotteryResult(winLottery: Lottery): LottoResult {
        val statistics = purchasedLotteries.compareWinningLottery(winLottery)
        val yield = calculateTotalReward(statistics).div(usedMoney.toDouble())
        return LottoResult(yield = yield, statistics = statistics)
    }

    fun toPurchasedLotteries() = purchasedLotteries.map { it.toLotteryNumbers() }

    private fun calculateTotalReward(result: Map<Rank, Int>) =
        result.map { it.key.calculatePrice(it.value) }
            .reduce { total, num -> total + num }
}
