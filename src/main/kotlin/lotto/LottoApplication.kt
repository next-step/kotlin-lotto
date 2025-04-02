package lotto

import lotto.domain.Amount
import lotto.domain.Lottery
import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.requestPurchaseAmount()
    val amount = Amount(purchaseAmount.toBigDecimal())

    val lottoMachine = LottoMachine()
    val lottos = lottoMachine.createLottos(amount)
    OutputView.printLottos(lottos)

    val winningNumbers = InputView.requestWinningNumbers()
    val winningLotto = Lotto(*winningNumbers.toIntArray())

    val rawBonusNumber = InputView.requestBonusNumber()
    val bonusNumber = LottoNumber.from(rawBonusNumber)

    val lottery = Lottery(lottos, winningLotto, bonusNumber)
    OutputView.printWinningStatistics(lottery)
}
