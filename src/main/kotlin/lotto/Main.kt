package lotto

import lotto.seller.LottoSeller
import lotto.validation.PurchaseValidate
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val text = inputView.printEnterMoney()

    val purchaseValidate = PurchaseValidate()
    purchaseValidate.validate(text)

    val money = text.toInt()
    val lottoSeller = LottoSeller()
    val lottoPurchaseAmount = lottoSeller.calculateLottoPurchaseAmount(money)
    val lottoTickets = lottoSeller.sell(lottoPurchaseAmount)

    val resultView = ResultView()
    resultView.printPurchaseAmount(lottoPurchaseAmount)
    resultView.printPurchaseLottoTickets(lottoTickets)
}
