package lotto

import lottoview.LottoInputView
import lottoview.LottoOutputView

fun main() {
    val priceRule = LottoInputView.inputPurchaseAmount()
    println()
    val issuedLottos = LottoCreator.issue(priceRule.count)
    issuedLottos.forEach {
        println(it)
    }

    val winningInfo = LottoInputView.inputWinningNumbers()
    println()
    val revenue = LottoOutputView.resultForWinning(issuedLottos, winningInfo)
    LottoOutputView.displayRevenue(priceRule.amount, revenue)
}
