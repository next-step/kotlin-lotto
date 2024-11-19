package lotto

import lotto.domain.LottoGenerator
import lotto.view.InputView
import lotto.view.ResultView


fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    ResultView.printPurchaseAmount(purchaseAmount)

    val lottoList = mutableListOf<List<Int>>()
    for (i in 1..purchaseAmount / 1000) {
        lottoList.add(LottoGenerator().generate())
    }

    ResultView.printLottoList(lottoList)

    val winningNumbers = InputView.getWinningNumbers()
    println("winningNumbers = ${winningNumbers}")
}

