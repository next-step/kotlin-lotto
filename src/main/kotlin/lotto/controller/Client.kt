package lotto.controller

import lotto.model.LottoResult
import lotto.model.LottoStore
import lotto.model.WinningCondition
import lotto.model.WinningCounter
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val moneyAmount = InputView.readMoney()
    val manualTicketCount = InputView.readManualTicketCount()
    val candidateNumbers = InputView.readCandidateNumbers(manualTicketCount)

    val store = LottoStore()
    val tickets = store.buy(moneyAmount, candidateNumbers)

    OutputView.printTickets(tickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber()

    val winningCounter = WinningCounter.Builder(WinningCondition(winningNumbers, bonusNumber)).build()

    tickets.forEach {
        winningCounter.record(it)
    }

    val result = LottoResult(winningCounter, moneyAmount)

    OutputView.printResult(result)
}
