package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val amount = InputView.getBuyAmount()
    if(amount == null) {
        println("구입금액을 정확히 입력해 주세요.")
        return
    }

    val buyAccount = InputView.getLottoBuyCount()
    if(buyAccount == null) {
        println("수동으로 구매할 로또 수를 정확히 입력해 주세요.")
        return
    }

    val ownedLotto = LottoMachine.buyLotto(amount)
    ResultView.showBuyResult(ownedLotto)

    val winLotto = InputView.getWinLotto()
    val bonusNumber = InputView.getBonusBall()
    LottoMachine.setWinLotto(winLotto, bonusNumber)

    val ranking = LottoMachine.generateRanking()
    ResultView.showGameResult(ranking)
}
