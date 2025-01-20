package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.view.InputView
import lotto.view.OutputView

class LottoApplication(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    fun run() {
        val money = inputView.inputMoney()
        val lotto = Lottos.buyLotto(money)
        outputView.showLottoCount(lotto)
        outputView.showLotto(lotto)

        val winningLotto: Lotto = inputView.inputWinningNumbers()
        val bonusNumber: LottoNumber = inputView.inputBonusNumber()

        val lottoResult = lotto.getResult(
            winningLotto = winningLotto,
            bonusLottoNumber = bonusNumber
        )
        outputView.showResult(lottoResult, money)
    }

}

fun main() {
    val lottoApplication = LottoApplication(InputView(), OutputView())
    lottoApplication.run()
}
