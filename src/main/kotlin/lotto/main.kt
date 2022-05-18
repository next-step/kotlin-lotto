package lotto

import lotto.domain.LottoSeller
import lotto.ui.LottoPurchaseView
import lotto.ui.StatisticsView
import lotto.ui.WinningLottoView

fun main() {
    LottoPurchaseView.inputPriceForPurchase()
        .let { LottoSeller().purchaseAuto(it).also { LottoPurchaseView.printPurchaseResult(it.size) } }
        .let { WinningLottoView.inputWinningLotto().match(it) }
        .let { StatisticsView.printResult(it) }
}
