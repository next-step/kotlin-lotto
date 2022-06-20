package lotto

import RandomIssueStrategy
import lottoview.LottoInputView
import lottoview.LottoInputView.displayPurchaseCount
import lottoview.LottoOutputView

fun main() {
    val priceRule = LottoInputView.inputPurchaseAmount()

    val userInputLottos = LottoCreator.createLottoTickets(priceRule.userInputNumber)
    val autoIssuedCount = priceRule.count
    val autoIssuedLottos = LottoCreator.issue(RandomIssueStrategy(autoIssuedCount))

    displayPurchaseCount(autoIssuedCount, userInputLottos.size)
    println()

    val allLottos = autoIssuedLottos + userInputLottos
    LottoOutputView.displayIssuedLottos(allLottos)

    val winningInfo = LottoInputView.inputWinningNumbersAndBonusNumber()
    allLottos.forEach {
        it.validate(winningInfo.winningLottoTicket)
    }

    winningInfo.setScore(allLottos)
    val revenuePercentage = winningInfo.getRevenuePercentage(priceRule.amount, winningInfo.revenue)

    println()

    LottoOutputView.resultForWinning(winningInfo)
    LottoOutputView.displayRevenue(revenuePercentage)
}
