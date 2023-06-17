package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val amount = InputView.getBuyAmount()
    val ownedLotto = LottoMachine.buyLotto(amount)
    ResultView.showBuyResult(ownedLotto)

    val winLotto = InputView.getWinLotto()
    val bonusNumber = InputView.getBonusBall()
    LottoMachine.setWinLotto(winLotto, bonusNumber)

    val ranking = LottoMachine.generateRanking()
    ResultView.showGameResult(ranking)
}
