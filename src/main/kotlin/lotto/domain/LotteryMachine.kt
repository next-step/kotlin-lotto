package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

object LotteryMachine {
    private const val PRICE = 1_000

    private val LOTTO_RETURN_MAP = mapOf(
        3 to 5_000,
        4 to 50_000,
        5 to 1_500_000,
        6 to 2_000_000_000
    )

    fun buyLotteries(payAmount: Int): Lotteries {
        val howMany = (payAmount / PRICE)
        val lotteryList = List(howMany) { Lottery(randomLottoNumbers()) }
        return Lotteries(lotteryList)
    }

    private fun randomLottoNumbers() = LottoNumber.allNumbers().shuffled().subList(0, Lottery.COUNT)

    fun getMatchCount(lotteries: Lotteries, lastWinningLottery: Lottery): LotteryMatchCount {
        val matchCount = lotteries.lotteries
            .groupingBy { it.countSameLottoNumbers(lastWinningLottery) }
            .eachCount()

        return LotteryMatchCount(matchCount)
    }

    fun calculateReturnRate(payAmount: Int, lotteryResult: LotteryMatchCount): BigDecimal {
        val totalPrize = LOTTO_RETURN_MAP.entries.map {
            it.value * (lotteryResult.matchCount[it.key] ?: 0)
        }.sum()

        return BigDecimal.valueOf(totalPrize / payAmount.toDouble())
            .setScale(2, RoundingMode.FLOOR)
    }
}
