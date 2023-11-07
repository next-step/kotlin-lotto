package lotto

import lotto.domain.DefaultLottoGenerateStrategy
import lotto.domain.LottoGenerator
import lotto.domain.LottoStore
import lotto.domain.LottoWinningMatcher
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val generator = LottoGenerator(DefaultLottoGenerateStrategy())
    val store = LottoStore(generator)

    val money = InputView.inputMoney()
    val boughtLottos = store.buyLottos(money)
    InputView.showBoughtLottos(boughtLottos)

    val winningNumbers = InputView.inputWinningNumbers()

    val checkedLottos = LottoWinningMatcher.match(boughtLottos, winningNumbers)

    ResultView.showResult(checkedLottos, money)
}
