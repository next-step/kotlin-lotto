package lotto.domain.order

import lotto.domain.Lottery
import lotto.domain.PurchasedLotteries
import lotto.domain.generator.LotteryGenerator

class PurchaseOrder(amount: Int) {

    private val maximumPurchaseQuantity: Int = (amount / Lottery.LOTTERY_PRICE).toInt()

    val purchasedLotteries: PurchasedLotteries = (ZERO until maximumPurchaseQuantity)
        .map { LotteryGenerator.draw() }
        .run(::PurchasedLotteries)

    constructor(amountText: String) : this(
        amount = amountText.toInt(),
    )

    companion object {
        private const val ZERO: Int = 0
    }
}
