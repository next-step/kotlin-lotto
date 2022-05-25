package lotto

import lotto.domain.LottoStore
import lotto.domain.UserMoney
import lotto.view.InputView
import lotto.view.PrintView

fun main() {
    val userMoneyInput = InputView.getUserMoney()

    val userMoney = UserMoney(userMoneyInput)
    val lottoStore = LottoStore(userMoney)

    PrintView.printLottoCount(lottoStore.lottoCount)
    PrintView.printBoughtLottoList(lottoStore.boughtLottos)

    val answer = InputView.getLottoAnswer()
    val bonusBall = InputView.getBonusBall()
    val winnerInfos = lottoStore.getLottoResult(answer, bonusBall)
    PrintView.printWinnerInfos(winnerInfos)

    val yieldRatio = lottoStore.totalYieldRatio
    PrintView.printYield(yieldRatio)
}
