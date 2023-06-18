package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.ResultView

const val EMPTY_SIZE = 0

fun main() {
    val amount = InputView.getInputBuyAmount()
    val buyCount = InputView.getInputBuyHandCount()
    val lotteriesByHand = InputView.getInputLotteryGroup(buyCount)

    val myLotteries = LottoMachine.buyLottery(amount, lotteriesByHand) ?: return
    ResultView.showBuyResult(myLotteries)

    val winLottery = InputView.getWinLotteryGroup()
    val bonusBall = InputView.getInputBonusBall()

    runCatching {
        LottoMachine.setWinLotto(winLottery, bonusBall)
    }.getOrElse {
        it.printStackTrace()
    }

    val ranking = LottoMachine.generateRanking()
    ResultView.showGameResult(ranking)
}
