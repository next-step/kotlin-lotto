package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val buyAmount = InputView.getBuyAmount()
    if(InputValidator.canBuyLotto(buyAmount)) {
        LottoMachine.buyLotto(buyAmount)
        ResultView.showBuyResult(LottoMachine.lottoCount, LottoMachine.buyedLotto)
        InputView.getWinNumbers()
    } else {
        ResultView.endGameForCannotBuy()
    }
}
