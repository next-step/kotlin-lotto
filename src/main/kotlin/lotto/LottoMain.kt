package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val buyAmount = InputView.getBuyAmount()
    if (InputValidator.canBuyLotto(buyAmount)) {
        LottoMachine.buyLotto(buyAmount)
        ResultView.showBuyResult(LottoMachine.lottoCount, LottoMachine.buyedLottoes)
        LottoMachine.setWinNumbers(InputView.getWinNumbers())
        ResultView.showGameResult()
    } else {
        ResultView.endGameForCannotBuy()
    }
}
