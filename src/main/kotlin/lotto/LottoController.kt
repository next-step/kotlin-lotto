package lotto

import lotto.domain.LottoTicket
import lotto.domain.Money
import lotto.domain.WinningTicket
import lotto.domain.machine.LottoFactory
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val moneyValue = InputView.inputMoneyValue()
    val money = Money.of(moneyValue)

    val lottoFactory = LottoFactory(money)

    val manualCount = InputView.inputManualCount()

    val manualLottoNumbers = InputView.inputManualLottoNumbers(manualCount)
    val tickets = lottoFactory.buyTickets(manualLottoNumbers)

    ResultView.printTickets(manualCount, tickets)

    val numbers = InputView.inputWinningNumber()
    val bonusNumber = InputView.inputBonusNumber()

    val winningTicket = WinningTicket.of(numbers, bonusNumber)

    val awardResults = winningTicket.awardResults(tickets)
    ResultView.printResults(awardResults)

}

class LottoController {
}
