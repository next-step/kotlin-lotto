package lotto

import lotto.domain.DefaultLottoGenerateStrategy
import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoStore
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val generator = LottoGenerator(DefaultLottoGenerateStrategy())
    val store = LottoStore(generator)

    val money = InputView.inputMoney()
    val boughtLottos = store.buyLottos(money)
    InputView.showBoughtLottos(boughtLottos)

    val winningLotto = Lotto(InputView.inputWinningNumbers())

    val checkedLottos = boughtLottos.matchAll(winningLotto)
    val returnRate = boughtLottos.totalReward() / money.toDouble()

    ResultView.showResult(checkedLottos, returnRate)
}
