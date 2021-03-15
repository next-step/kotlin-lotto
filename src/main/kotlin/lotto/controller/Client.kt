package lotto.controller

import lotto.model.LottoResult
import lotto.model.LottoStore
import lotto.model.WinningCondition
import lotto.model.WinningCounter
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val moneyAmount = InputView.readMoney()

    val store = LottoStore()
    val tickets = store.buy(moneyAmount)

    OutputView.printTickets(tickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber()

    val winningCounter = WinningCounter(tickets, WinningCondition(winningNumbers, bonusNumber))
    val result = LottoResult(winningCounter, moneyAmount)

    OutputView.printResult(result)
}
