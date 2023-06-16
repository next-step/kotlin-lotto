package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val buyAmount = InputView.getBuyAmount()
    if(InputValidator.canBuyLotto(buyAmount)) {

    } else {
        ResultView.endGameForCannotBuy()
    }
}
