package lotto

import lotto.domain.LottoMachine
import lotto.domain.GameMoney
import lotto.ui.InputView
import lotto.ui.ResultView
import lotto.util.Splitter

fun main() {
    val splitter = Splitter()

    val gameMoney = GameMoney.from(InputView.requestMoney())
    val manualLottoStrs = InputView.requestManualLottos()
    val lottoMachine = LottoMachine()
    val manualLottos = manualLottoStrs.map { splitter.toNumbers(it) }
    val lottoTicket = lottoMachine.generateTicket(gameMoney, manualLottos)
    ResultView.printPurchasedTicket(lottoTicket)

    val winningNumbers = InputView.requestWinningNumbers()
    val numbers = splitter.toNumbers(winningNumbers)
    val bonusNumber = InputView.requestBonusNumber()
    val winningLotto = lottoMachine.toWinningLotto(numbers, bonusNumber)

    val matches = lottoTicket.match(winningLotto)
    ResultView.printStatistics(matches, gameMoney)
}
