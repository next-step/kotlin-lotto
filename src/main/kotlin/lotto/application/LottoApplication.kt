package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.LottoVendingMachine
import lotto.view.InputView
import lotto.view.OutputView

class LottoApplication(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    fun run() {
        val money = inputView.inputMoney()
        val lotto = LottoVendingMachine.buyLotto(money)
        outputView.showLottoCount(lotto)
        outputView.showLotto(lotto)

        val winningLotto: Lotto = inputView.inputWinningNumbers()

        val lottoResult= LottoResult.makeLottoResult(
            winningLotto = winningLotto,
            lottos = lotto,
        )
        outputView.showResult(lottoResult, money)
    }

}

fun main() {
    val lottoApplication = LottoApplication(InputView(), OutputView())
    lottoApplication.run()
}
