package lotto

import RandomIssueStrategy
import lottoview.LottoInputView
import lottoview.LottoOutputView

fun main() {
    val priceRule = LottoInputView.inputPurchaseAmount()

    println()

    val issuedLottos = LottoCreator.issue(RandomIssueStrategy(priceRule.count))
    LottoOutputView.displayIssuedLottos(issuedLottos)

    val winningInfo = LottoInputView.inputWinningNumbers()
    winningInfo.setScore(issuedLottos)
    val revenuePercentage = winningInfo.getRevenuePercentage(priceRule.amount, winningInfo.revenue)

    println()

    LottoOutputView.resultForWinning(winningInfo)
    LottoOutputView.displayRevenue(revenuePercentage)
}
