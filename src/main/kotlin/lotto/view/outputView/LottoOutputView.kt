package lotto.view.outputView

import lotto.domain.Lotto
import lotto.domain.LottoPrize
import lotto.domain.Money

class LottoOutputView : OutputView {
    override fun printLottoBuyResult(lottos: List<Lotto>) {
        println(BUY_RESULT_MSG.format(lottos.size))
        lottos.forEach { println(it.numbers) }
        println()
    }

    override fun printLottoWinCheckResult(paidMoney: Money, prizes: List<LottoPrize>) {
        val countContainer = mutableMapOf(
            LottoPrize.FOURTH to INITIAL_COUNT,
            LottoPrize.THIRD to INITIAL_COUNT,
            LottoPrize.SECOND to INITIAL_COUNT,
            LottoPrize.FIRST to INITIAL_COUNT,
        )
        var totalPrizeAmount = Money(0)

        prizes.forEach {
            increaseCount(countContainer, it)
            totalPrizeAmount += it.amount
        }

        printLottoPrizes(countContainer)
        printProfitRatio(paidMoney, totalPrizeAmount)
    }

    private fun increaseCount(countContainer: MutableMap<LottoPrize, Int>, lottoPrize: LottoPrize) {
        val count = countContainer[lottoPrize] ?: INITIAL_COUNT
        countContainer[lottoPrize] = count + 1
    }

    private fun printLottoPrizes(countContainer: MutableMap<LottoPrize, Int>) {
        println()
        println("당첨 통계")
        println("---------")
        countContainer.forEach { (prize, count) -> printLottoPrize(prize, count) }
    }

    private fun printLottoPrize(lottoPrize: LottoPrize, count: Int) {
        println(LOTTO_PRIZE_RESULT_TEMPLATE.format(lottoPrize.matchCount, lottoPrize.amount, count))
    }

    private fun printProfitRatio(paidMoney: Money, totalPrizeAmount: Money) {
        val profitRatio = totalPrizeAmount.value.toDouble() / paidMoney.value.toDouble()
        println(PROFIT_RATIO_TEMPLATE.format(profitRatio))
    }

    companion object {
        private const val INITIAL_COUNT = 0
        private const val BUY_RESULT_MSG = "%s개를 구매했습니다."
        private const val LOTTO_PRIZE_RESULT_TEMPLATE = "%s개 일치 (%s원)- %s개"
        private const val PROFIT_RATIO_TEMPLATE = "총 수익률은 %.2f입니다."
    }
}
