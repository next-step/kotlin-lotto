package lotto

import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputMoney = InputView.readLottoPurchaseAmount()
    val lottos = LottoGame().generateLotto(inputMoney)
    ResultView.showLottos(lottos)
}
