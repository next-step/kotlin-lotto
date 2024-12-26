package lotto.application

import lotto.Lotto
import lotto.LottoResult
import lotto.LottoVendingMachine
import lotto.view.InputView
import lotto.view.OutputView

class LottoApplication(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    fun run() {
        outputView.showInputMoneyMessage()
        val money = inputView.inputMoney()
        val lotto = LottoVendingMachine.buyLotto(money)
        outputView.showLottoCount(lotto)
        outputView.showLotto(lotto)

        outputView.showInputWinningNumbersMessage()
        val winningNumbers: List<Int> = inputView.inputWinningNumbers()

        val lottoResult= LottoResult.makeLottoResult(
            winningLotto = Lotto(*winningNumbers.toIntArray()),
            lottos = lotto,
        )
        outputView.showResult(lottoResult, money)
    }

}

fun main() {
    val lottoApplication = LottoApplication(InputView(), OutputView())
    lottoApplication.run()
}
