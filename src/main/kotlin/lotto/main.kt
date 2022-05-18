package lotto

import lotto.domain.LottoSeller
import lotto.ui.LottoPurchaseView
import lotto.ui.StatisticsView
import lotto.ui.WinningLottoView

fun main() {
    LottoPurchaseView.inputPriceForPurchase()
        .let {
            LottoSeller().purchaseAuto(it)
                .also { lotteList -> LottoPurchaseView.printPurchaseResult(lotteList) }
        }
        .let { WinningLottoView.inputWinningLotto().match(it) }
        .let { StatisticsView.printResult(it) }
}
