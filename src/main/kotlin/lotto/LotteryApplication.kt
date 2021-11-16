package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.Money
import lotto.domain.Order
import lotto.domain.WinningLottery
import lotto.domain.strategy.LottoNumberAutoGenerator
import lotto.ui.LottoView

fun main() = LotteryApplication(
    LottoView,
    LottoMachine(LottoNumberAutoGenerator)
).run()

class LotteryApplication(
    private val view: LottoView,
    private val machine: LottoMachine
) {
    fun run() {
        view.inputPrompt()
        val money = Money.from(view.input())

        val total = machine.count(money)
        val manual = view.inputManualCountPrompt()
        val selected = view.inputSelectedLottoNumbersPrompt(manual)

        val order = Order.of(total, manual, selected)

        val lotteries = machine.buy(order)
        val paid = machine.calculatePaid(order)

        view.displayLotteries(lotteries)
        val winningNumbers = view.inputNumbers()

        view.inputBonusBallPrompt()
        val bonusBall = LottoNumber.of(view.input())
        val winningLottery = WinningLottery.of(winningNumbers, bonusBall)

        val statistics = machine.calculate(lotteries, winningLottery)
        val earn = machine.settle(statistics)
        val ratio = machine.calculateYield(paid, earn)

        view.displayStatistics(statistics, ratio)
    }
}
