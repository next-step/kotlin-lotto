package lotto

import lotto.domain.Lotteries
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.Money
import lotto.domain.Order
import lotto.domain.WinningLottery
import lotto.domain.strategy.DefaultLottoNumberAutoGenerator
import lotto.ui.LottoView

fun main() = LotteryApplication(
    LottoView,
    LottoMachine(DefaultLottoNumberAutoGenerator)
).run()

class LotteryApplication(
    private val view: LottoView,
    private val machine: LottoMachine
) {
    fun run() {
        val order = getOrder()
        val lotteries = machine.buy(order)
        val paid = machine.calculatePaid(order)

        view.displayLotteries(lotteries)

        val winningLottery = getWinningLottery()

        showResult(lotteries, winningLottery, paid)
    }

    private fun getOrder(): Order {
        view.inputPrompt()
        val money = Money.from(view.input())

        val total = machine.count(money)
        val manualLotteryCount = view.inputManualCountPrompt()
        val selectedLottoNumbers = view.inputSelectedLottoNumbersPrompt(manualLotteryCount)

        return Order.of(total, manualLotteryCount, selectedLottoNumbers)
    }

    private fun getWinningLottery(): WinningLottery {
        val winningNumbers = view.inputNumbers()

        view.inputBonusBallPrompt()
        val bonusBall = LottoNumber.of(view.input())
        return WinningLottery.of(winningNumbers, bonusBall)
    }

    private fun showResult(lotteries: Lotteries, winningLottery: WinningLottery, paid: Money) {
        val statistics = machine.calculate(lotteries, winningLottery)
        val earn = machine.settle(statistics)
        val ratio = machine.calculateYield(paid, earn)

        view.displayStatistics(statistics, ratio)
    }
}
