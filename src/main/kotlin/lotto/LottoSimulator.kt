package lotto

import lotto.LottoWinningHandler.calculateRevenue
import lottoview.LottoInputView
import lottoview.LottoOutputView

fun main() {
    val priceRule = LottoInputView.inputPurchaseAmount()

    println()

    val issuedLottos = LottoCreator.issue(priceRule.count)
    LottoOutputView.displayIssuedLottos(issuedLottos)

    val winningInfo = LottoInputView.inputWinningNumbers()
    winningInfo.setScore(issuedLottos)

    println()

    LottoOutputView.resultForWinning(winningInfo)
    val revenue = calculateRevenue(winningInfo.scoreInfos)

    LottoOutputView.displayRevenue(priceRule.amount, revenue)
}
