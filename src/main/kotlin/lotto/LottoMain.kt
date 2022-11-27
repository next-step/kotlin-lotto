package lotto

import lotto.domain.Wallet
import lotto.domain.WinningLotto
import lotto.views.InputView
import lotto.views.ResultView

fun main() {

    val inputView = InputView()
    val resultView = ResultView()

    val wallet = Wallet()

    val money = inputView.insertMoney()
    wallet.insertMoney(money)

    val lottos = wallet.buyLottos()
    resultView.printLottos(lottos)

    val winningLotto = inputView.getWinningLotto()
    val result = wallet.indicateLottoStatistics(WinningLotto.byInput(winningLotto))
    resultView.printResult(result)
}
