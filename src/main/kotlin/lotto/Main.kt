package lotto

import lotto.seller.LottoSeller
import lotto.validation.PurchaseValidate

fun main() {
    val text = readln()
    val purchaseValidate = PurchaseValidate()
    purchaseValidate.validate(text)

    val money = text.toInt()
    val lottoSeller = LottoSeller()
    val lottoPurchaseAmount = lottoSeller.calculateLottoPurchaseAmount(money)
    lottoSeller.sell(lottoPurchaseAmount)
}
