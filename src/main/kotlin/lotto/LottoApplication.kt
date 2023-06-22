package lotto

import lotto.service.LottoShop
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseMoney = InputView.purchaseMoney()
    val lottos = LottoShop.purchase(purchaseMoney)
    ResultView.printPurchaseLottoNum(lottos)
    ResultView.printLottos(lottos)
}
