package lotto

import lotto.domain.LottoStore
import lotto.view.InputView
import lotto.view.PrintView

fun main() {
    val inputView = InputView()

    val userMoneyInput = inputView.getUserMoney()

    val lottoStore = LottoStore(userMoneyInput)

    val printView = PrintView()
    printView.printLottoCount(lottoStore.lottoCount)
    printView.printBoughtLottoList(lottoStore.boughtLottos)

    val answer = inputView.getLottoAnswer()
    val winnerInfos = lottoStore.getLottoResult(answer)
    printView.printWinnerInfos(winnerInfos)

    val yieldRatio = lottoStore.totalYieldRatio
    printView.printYield(yieldRatio)

}