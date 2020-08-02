package lotto

import lotto.model.Buyer
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.getAmountOfMoney()
    val lottos = Buyer().buyLotto(money)

    ResultView.printLottoCount(lottos)
    ResultView.printLottos(lottos)

    val winnerLotto = InputView.getWinnerLotto()
}
