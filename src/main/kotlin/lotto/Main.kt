package lotto

import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val money = InputView.requestMoney()
    val lottoMachine = LottoMachine()
    val lottoTicket = lottoMachine.generateTicket(money)
    ResultView.printPurchasedTicket(lottoTicket)

    val winningNumbers = InputView.requestWinningNumbers()
    val winningLotto = lottoMachine.toWinningLotto(winningNumbers)

    val matches = lottoTicket.match(winningLotto)
    ResultView.printMatchResult(matches)
}

