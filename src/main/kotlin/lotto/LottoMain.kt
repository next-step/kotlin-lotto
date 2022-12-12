package lotto

import lotto.domain.Wallet
import lotto.domain.WinningLotto
import lotto.views.InputView
import lotto.views.ResultView

fun main() {
    val wallet = Wallet()

    val money = InputView.insertMoney()
    wallet.insertMoney(money)

    val lottos = wallet.buyLottos()
    ResultView.printLottos(lottos)

    val winningLottoNumbers = InputView.getWinningLottoNumbers()
    val winningBonusNumber = InputView.getBonusNumber()

    val result =
        wallet.indicateLottoStatistics(WinningLotto.byInput(winningLottoNumbers, winningBonusNumber))
    ResultView.printResult(result)
}
