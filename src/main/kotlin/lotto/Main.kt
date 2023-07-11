package lotto

import lotto.domain.LottoMachine
import lotto.domain.Money
import lotto.ui.InputView
import lotto.ui.ResultView
import lotto.util.Splitter

fun main() {
    val money = Money.from(InputView.requestMoney())
    val lottoMachine = LottoMachine()
    val lottoTicket = lottoMachine.generateTicket(money)
    ResultView.printPurchasedTicket(lottoTicket)

    val winningNumbers = InputView.requestWinningNumbers()
    val numbers = Splitter().toNumbers(winningNumbers)
    val bonusNumber = InputView.requestBonusNumber()
    val winningLotto = lottoMachine.toWinningLotto(numbers, bonusNumber)

    val matches = lottoTicket.match(winningLotto)
    ResultView.printStatistics(matches, money)
}
