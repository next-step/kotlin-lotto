package lotto

import lotto.domain.LottoStore
import lotto.view.InputView
import lotto.view.PrintView

fun main() {
    val userMoneyInput = InputView.getUserMoney()

    val lottoStore = LottoStore(userMoneyInput)

    PrintView.printLottoCount(lottoStore.lottoCount)
    PrintView.printBoughtLottoList(lottoStore.boughtLottos)

    val answer = InputView.getLottoAnswer()
    val winnerInfos = lottoStore.getLottoResult(answer)
    PrintView.printWinnerInfos(winnerInfos)

    val yieldRatio = lottoStore.totalYieldRatio
    PrintView.printYield(yieldRatio)
}
