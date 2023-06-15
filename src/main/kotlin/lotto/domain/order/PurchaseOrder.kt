package lotto.domain.order

import lotto.domain.LotteryAdaptor
import lotto.domain.PurchasedLotteries
import lotto.domain.generator.LotteryGenerator

class PurchaseOrder(amount: Int) {

    private val maximumPurchaseQuantity: Int = (amount / LotteryAdaptor.LOTTERY_PRICE).toInt()

    val purchasedLotteries: PurchasedLotteries = List(maximumPurchaseQuantity) { LotteryGenerator.draw() }
        .run(::PurchasedLotteries)

    constructor(amountText: String) : this(
        amount = amountText.toInt(),
    )
}
