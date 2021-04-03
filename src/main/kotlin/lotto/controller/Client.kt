package lotto.controller

import lotto.model.LottoResult
import lotto.model.LottoStore
import lotto.model.Money
import lotto.model.RandomNumbersGenerator
import lotto.model.winning.WinningCondition
import lotto.model.winning.WinningCounter
import lotto.model.number.LottoNumber
import lotto.model.number.LottoNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val moneyAmount = Money(InputView.readMoney())
    val manualTicketCount = InputView.readManualTicketCount()
    val listOfCandidateNumbers = InputView.readListOfCandidateNumbers(manualTicketCount).map { LottoNumbers(it) }

    val store = LottoStore(RandomNumbersGenerator())
    val tickets = store.buy(moneyAmount, listOfCandidateNumbers)

    OutputView.printTickets(tickets)

    val winningNumbers = LottoNumbers(InputView.readWinningNumbers())
    val bonusNumber = LottoNumber.get(InputView.readBonusNumber())

    val winningCounter = WinningCounter(tickets, WinningCondition(winningNumbers, bonusNumber))

    val result = LottoResult(winningCounter, moneyAmount)

    OutputView.printResult(result)
}
