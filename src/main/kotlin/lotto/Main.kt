package lotto

import lotto.domain.DefaultLottoGenerateStrategy
import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoStore
import lotto.domain.WinningLotto
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val generator = LottoGenerator(DefaultLottoGenerateStrategy())
    val store = LottoStore(generator)

    val money = InputView.inputMoney()
    val boughtLottos = store.buyLottos(money)
    ResultView.showBoughtLottos(boughtLottos)

    val winningLotto = WinningLotto(Lotto(InputView.inputWinningNumbers()), InputView.inputBonusNumber())

    val checkedLottos = boughtLottos.matchAll(winningLotto)
    val returnRate = checkedLottos.totalReward() / money.toDouble()

    ResultView.showResult(checkedLottos, returnRate)
}
