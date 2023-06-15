package lottery.domain

import lottery.domain.lottery.Lotteries
import lottery.domain.lottery.Lottery
import lottery.domain.lottery.generator.LotteryGenerator
import java.math.BigDecimal
import java.math.RoundingMode

class Wallet(
    money: Money,
    private val lotteries: Lotteries = Lotteries.init()
) {
    var money: Money = money
        private set

    fun buyLotteries(randomLotteryGenerator: LotteryGenerator): List<Lottery> {
        check(Lottery.canBuyLottery(money)) { "로또를 사기엔 부족한 금액이다" }
        val receipt = Lottery.buyLottery(money)
        return buyLotteriesByReceipt(receipt, randomLotteryGenerator)
    }

    fun calculateLotteryResult(winLottery: Lottery): LottoResult {
        val statistics = lotteries.compareWinningLottery(winLottery)
        val lottoYield = calculateYield(statistics)
        return LottoResult(lottoYield = lottoYield, statistics = statistics)
    }

    private fun generateLottery(buyCount: Int, lotteryGenerator: LotteryGenerator): List<Lottery> =
        lotteryGenerator.generateLotteries(buyCount)

    private fun buyLotteriesByReceipt(receipt: Receipt, randomLotteryGenerator: LotteryGenerator): List<Lottery> {
        money -= receipt.usedMoney
        val buyLotteries = generateLottery(receipt.buyCount, randomLotteryGenerator)
        lotteries.addLotteries(buyLotteries)
        return buyLotteries
    }

    private fun calculateYield(statistics: Map<Rank, Int>): BigDecimal =
        calculateTotalReward(statistics).divide(lotteries.cost().value, YIELD_CALCULATE_DIVIDE_SCALE, RoundingMode.UP)

    private fun calculateTotalReward(result: Map<Rank, Int>): BigDecimal =
        result.map { it.key.calculatePrice(it.value) }
            .reduce { total, num -> total + num }
            .toBigDecimal()

    companion object {
        private const val YIELD_CALCULATE_DIVIDE_SCALE = 2
    }
}
