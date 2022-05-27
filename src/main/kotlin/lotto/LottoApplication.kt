package lotto

import lotto.domain.LottoPurchase
import lotto.domain.LottoPurchase.Companion.LOTTO_PRICE
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val price = inputView.readPrice()

    val lottoPurchase = LottoPurchase()
    val lottoPrice = lottoPurchase.getMoney(price)

    if (lottoPrice.get() < LOTTO_PRICE) {
        outputView.cannotPurchaseLotto()
        return
    }

    val lottoCount = lottoPurchase.getLotto(lottoPrice)
    outputView.resultPurchaseLotto(lottoCount)

    val lottoTickets = lottoPurchase.getLottoTickets(lottoCount)
    outputView.resultLottoTickets(lottoTickets)
}
