package lotto

import lotto.domain.*
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val generator = LottoGenerator(DefaultLottoGenerateStrategy())
    val store = LottoStore(generator)

    val money = InputView.inputMoney()
    val boughtLottos = store.buyLottos(money)
    ResultView.showBoughtLottos(boughtLottos)

    val winningLotto = WinningLotto(Lotto(InputView.inputWinningNumbers()), LottoNumber(InputView.inputBonusNumber()))

    val checkedLottos = boughtLottos.matchAll(winningLotto)
    val returnRate = checkedLottos.totalReward() / money.toDouble()

    ResultView.showResult(checkedLottos, returnRate)
}
