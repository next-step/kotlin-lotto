package lotto

import lotto.ui.LottoMatchingView
import lotto.ui.LottoPurchaseView
import lotto.ui.StatisticsView

fun main() {
    val money = LottoPurchaseView.inputPriceForPurchase()
    val lottoList = LottoPurchaseView.purchase(money)
    val matchingMap = LottoMatchingView.match(lottoList)
    StatisticsView.printResult(money, matchingMap)
}
