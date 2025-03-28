package lotto

import lotto.domain.Amount
import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.requestPurchaseAmount()
    val amount = Amount(purchaseAmount)

    val lottoMachine = LottoMachine()
    val lottos = lottoMachine.createLottos(amount)
    OutputView.printLottos(lottos)

    val winningNumbers = InputView.requestWinningNumbers()
    val winningLotto = Lotto.fromRawNumbers(winningNumbers)
}
