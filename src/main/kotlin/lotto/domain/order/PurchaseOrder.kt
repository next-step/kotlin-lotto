package lotto.domain.order

import lotto.domain.Lottery
import lotto.domain.PurchasedLotteries
import lotto.domain.generator.LotteryGenerator
import lotto.model.LottoErrorCode

class PurchaseOrder(amount: Int) {

    private val maximumPurchaseQuantity: Int = (amount / Lottery.LOTTERY_PRICE).toInt()

    @OptIn(ExperimentalStdlibApi::class)
    val purchasedLotteries: PurchasedLotteries = (ZERO ..< maximumPurchaseQuantity)
        .map { LotteryGenerator.draw() }
        .run(::PurchasedLotteries)

    constructor(amountText: String) : this(
        amount = requireNotNull(value = amountText.toIntOrNull()) {
            LottoErrorCode.INVALID_PURCHASE_AMOUNT.message(amountText)
        },
    )

    companion object {
        private const val ZERO: Int = 0
    }
}
