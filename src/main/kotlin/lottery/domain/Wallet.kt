package lottery.domain

import lottery.domain.lottery.Lotteries
import lottery.domain.lottery.Lottery
import java.math.BigDecimal
import java.math.RoundingMode

class Wallet(
    val usedMoney: BigDecimal,
    val purchasedLotteries: Lotteries
) {
    fun calculateLotteryResult(winLottery: Lottery): LottoResult {
        val statistics = purchasedLotteries.compareWinningLottery(winLottery)
        val lottoYield = calculateYield(statistics)
        return LottoResult(lottoYield = lottoYield, statistics = statistics)
    }

    fun toPurchasedLotteries() = purchasedLotteries.map { it.toLotteryNumbers() }

    private fun calculateYield(statistics: Map<Rank, Int>) =
        calculateTotalReward(statistics).divide(usedMoney, YIELD_CALCULATE_DIVIDE_SCALE, RoundingMode.UP)

    private fun calculateTotalReward(result: Map<Rank, Int>) =
        result.map { it.key.calculatePrice(it.value) }
            .reduce { total, num -> total + num }
            .toBigDecimal()

    companion object {
        private const val YIELD_CALCULATE_DIVIDE_SCALE = 2
    }
}
