package lottery.domain

import lottery.domain.lottery.Lotteries
import lottery.domain.lottery.Lottery
import lottery.domain.lottery.PurchasedLotteriesResult
import lottery.domain.lottery.WinningLottery
import lottery.domain.lottery.generator.LotteryGenerator
import lottery.domain.rank.Rank
import java.math.BigDecimal
import java.math.RoundingMode

class Wallet(
    money: Money,
    private val manualLotteries: Lotteries = Lotteries.init(),
    private val randomLotteries: Lotteries = Lotteries.init(),
) {
    init {
        require(Lottery.canPurchaseLottery(money)) { "로또를 사기엔 부족한 금액이다" }
    }

    var money: Money = money
        private set

    fun purchaseManualLotteries(manualLotteries: List<List<String>>): List<Lottery> {
        require(Lottery.canPurchaseLottery(manualLotteries.size, money)) { "수동 로또를 사기엔 부족한 금액이다" }
        val purchasedManualLotteries = Lotteries.from(manualLotteries)
        return purchaseManualLotteries(purchasedManualLotteries)
    }

    fun purchaseLotteries(randomLotteryGenerator: LotteryGenerator): List<Lottery> {
        val receipt = Lottery.purchaseLottery(money)
        return purchaseLotteriesByReceipt(receipt, randomLotteryGenerator)
    }

    fun calculateLotteryResult(winLottery: WinningLottery): LottoResult {
        val statistics = randomLotteries.compareWinningLottery(winLottery)
        val lottoYield = calculateYield(statistics)
        return LottoResult(lottoYield = lottoYield, statistics = statistics)
    }

    fun purchasedLotteries(): PurchasedLotteriesResult = PurchasedLotteriesResult(
        manualCount = manualLotteries.size(),
        randomCount = randomLotteries.size(),
        purchasedAllLotteries = Lotteries.merge(manualLotteries, randomLotteries).values,
    )

    private fun purchaseManualLotteries(purchasedManualLotteries: Lotteries): MutableList<Lottery> {
        money -= purchasedManualLotteries.cost()
        this.manualLotteries.addLotteries(purchasedManualLotteries)
        return purchasedManualLotteries.values
    }

    private fun purchaseLotteriesByReceipt(receipt: Receipt, lotteryGenerator: LotteryGenerator): List<Lottery> {
        money -= receipt.usedMoney
        val purchasedLotteries = generateLottery(receipt.purchaseCount, lotteryGenerator)
        this.randomLotteries.addLotteries(purchasedLotteries)
        return purchasedLotteries
    }

    private fun generateLottery(purchaseCount: Int, lotteryGenerator: LotteryGenerator): List<Lottery> =
        lotteryGenerator.generateLotteries(purchaseCount)

    private fun calculateYield(statistics: Map<Rank, Int>): BigDecimal =
        calculateTotalReward(statistics).divide(randomLotteries.cost().value, YIELD_CALCULATE_DIVIDE_SCALE, RoundingMode.DOWN)

    private fun calculateTotalReward(result: Map<Rank, Int>): BigDecimal =
        result.map { it.key.calculatePrice(it.value) }
            .reduce { total, num -> total + num }
            .toBigDecimal()

    companion object {
        private const val YIELD_CALCULATE_DIVIDE_SCALE = 2
    }
}
