package lottery.domain

import lottery.domain.lottery.Lotteries
import lottery.domain.lottery.Lottery
import lottery.domain.lottery.generator.LotteryGenerator
import java.math.BigDecimal
import java.math.RoundingMode

class Wallet(
    money: Money,
    private val purchaseLotteries: Lotteries = Lotteries.init()
) {
    var money: Money = money
        private set

    fun purchaseLotteries(randomLotteryGenerator: LotteryGenerator): List<Lottery> {
        check(Lottery.canPurchaseLottery(money)) { "로또를 사기엔 부족한 금액이다" }
        val receipt = Lottery.purchaseLottery(money)
        return purchaseLotteriesByReceipt(receipt, randomLotteryGenerator)
    }

    fun calculateLotteryResult(winLottery: Lottery): LottoResult {
        val statistics = purchaseLotteries.compareWinningLottery(winLottery)
        val lottoYield = calculateYield(statistics)
        return LottoResult(lottoYield = lottoYield, statistics = statistics)
    }

    private fun generateLottery(purchaseCount: Int, lotteryGenerator: LotteryGenerator): List<Lottery> =
        lotteryGenerator.generateLotteries(purchaseCount)

    private fun purchaseLotteriesByReceipt(receipt: Receipt, randomLotteryGenerator: LotteryGenerator): List<Lottery> {
        money -= receipt.usedMoney
        val purchaseLotteries = generateLottery(receipt.purchaseCount, randomLotteryGenerator)
        this.purchaseLotteries.addLotteries(purchaseLotteries)
        return purchaseLotteries
    }

    private fun calculateYield(statistics: Map<Rank, Int>): BigDecimal =
        calculateTotalReward(statistics).divide(purchaseLotteries.cost().value, YIELD_CALCULATE_DIVIDE_SCALE, RoundingMode.DOWN)

    private fun calculateTotalReward(result: Map<Rank, Int>): BigDecimal =
        result.map { it.key.calculatePrice(it.value) }
            .reduce { total, num -> total + num }
            .toBigDecimal()

    companion object {
        private const val YIELD_CALCULATE_DIVIDE_SCALE = 2
    }
}
