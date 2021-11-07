package lotto

import lotto.domain.LottoMachine
import lotto.domain.Money
import lotto.domain.WinningLottery
import lotto.domain.strategy.LottoAutoGenerator
import lotto.ui.LottoView

fun main() = LotteryApplication(
    LottoView,
    LottoMachine(LottoAutoGenerator)
).run()

class LotteryApplication(
    private val view: LottoView,
    private val machine: LottoMachine
) {
    fun run() {
        view.inputPrompt()
        val budget = Money.valueOf(view.input())
        val lotteryCounts = machine.count(budget)
        val lotteries = machine.buy(lotteryCounts)
        val paid = machine.calculatePaid(lotteryCounts)

        view.displayLotteries(lotteries)
        val winning = WinningLottery.of(view.inputWinningNumbers())

        val statistics = machine.calculate(lotteries, winning.lottery)
        val earn = machine.settle(statistics)
        val ratio = machine.calculateYield(paid, earn)

        view.displayStatistics(statistics, ratio)
    }
}
