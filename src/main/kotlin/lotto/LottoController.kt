package lotto

import lotto.domain.LottoNumber
import lotto.domain.Money
import lotto.domain.WinningTicket
import lotto.domain.machine.DefaultLottoMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val moneyValue = InputView.inputMoneyValue()
    val money = Money.of(moneyValue)

    val lottoMachine = DefaultLottoMachine(money)

    val manualCount = InputView.inputManualCount()

    val manualLottoNumbers = InputView.inputManualLottoNumbers(manualCount)

    val manualTickets = lottoMachine.publishManual(manualLottoNumbers)
    val randomTickets = lottoMachine.publishRandom(LottoNumber.RANGE)

    val allTickets = manualTickets + randomTickets

    ResultView.printTickets(manualCount, allTickets)

    val numbers = InputView.inputWinningNumber()
    val bonusNumber = InputView.inputBonusNumber()

    val winningTicket = WinningTicket.of(numbers, bonusNumber)

    val awardResults = winningTicket.awardResults(allTickets)
    ResultView.printResults(awardResults)
}
