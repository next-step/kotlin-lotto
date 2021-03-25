package lotto.controller

import lotto.model.LottoResult
import lotto.model.LottoStore
import lotto.model.Money
import lotto.model.RandomNumbersGenerator
import lotto.model.WinningCondition
import lotto.model.WinningCounter
import lotto.model.number.LottoNumbersFactory
import lotto.model.number.WinningNumber
import lotto.model.number.WinningNumbersFactory
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val moneyAmount = Money(InputView.readMoney())
    val manualTicketCount = InputView.readManualTicketCount()
    val listOfCandidateNumbers = InputView.readListOfCandidateNumbers(manualTicketCount).map { LottoNumbersFactory.create(it) }

    val store = LottoStore(RandomNumbersGenerator())
    val tickets = store.buy(moneyAmount, listOfCandidateNumbers)

    OutputView.printTickets(tickets)

    val winningNumbers = WinningNumbersFactory.create(InputView.readWinningNumbers())
    val bonusNumber = WinningNumber.get(InputView.readBonusNumber())

    val winningCounter = WinningCounter.Builder(WinningCondition(winningNumbers, bonusNumber)).build()

    tickets.forEach {
        winningCounter.record(it)
    }

    val result = LottoResult(winningCounter, moneyAmount)

    OutputView.printResult(result)
}
