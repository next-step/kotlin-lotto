package lotto

import lotto.domain.LottoCalculator
import lotto.domain.LottoGenerator
import lotto.view.InputView

fun main() {
    val inputView = InputView()
    val totalPurchaseAmount = inputView.readTotalPurchaseAmount().toInt()
    val totalPurchaseCount = LottoCalculator().calculateLottoCount(
        totalPurchaseAmount = totalPurchaseAmount,
        pricePerAmount = 1000
    )
    // resultView 필요
    println("$totalPurchaseCount 개를 구매했습니다.")
}