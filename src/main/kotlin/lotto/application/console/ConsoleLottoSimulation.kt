package lotto.application.console

import lotto.domain.LottoBuy
import lotto.domain.LottoGame
import lotto.domain.LottoMachine
import lotto.domain.RandomLottoFactory

fun main() {

    val lottoMachine = LottoMachine(RandomLottoFactory())

    val cost = InputView.inputCost()
    val manualLottoCount = InputView.inputManualLottoCount()
    val manualLottos = InputView.inputManualLottos(manualLottoCount)

    val lottoReceipt = lottoMachine.buy(LottoBuy(cost, manualLottos))
    val lottos = lottoReceipt.lottos

    ResultView.printLottoReceipt(lottoReceipt)

    val winningNumbers = InputView.inputWinningNumbers()
    val bonusNumber = InputView.inputBonusNumber()
    val lottoGame = LottoGame(winningNumbers, bonusNumber)

    val summary = lottoGame.match(lottos)
    ResultView.printSummary(summary)
}
