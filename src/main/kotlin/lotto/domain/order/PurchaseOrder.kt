package lotto.domain.order

import lotto.domain.Lottery
import lotto.domain.LotteryAdaptor
import lotto.domain.PurchasedLotteries
import lotto.domain.generator.LotteryGenerator
import lotto.model.LottoErrorCode

class PurchaseOrder(amount: Int, val purchasedManualLotteries: PurchasedLotteries) {

    private val maximumAutoPurchaseQuantity: Int
    val purchasedAutoLotteries: PurchasedLotteries

    init {
        val maximumPurchaseQuantity = (amount / LotteryAdaptor.LOTTERY_PRICE).toInt()
        val manualLotteriesSize = purchasedManualLotteries.size

        maximumAutoPurchaseQuantity = maximumPurchaseQuantity - manualLotteriesSize

        check(value = maximumAutoPurchaseQuantity >= ZERO) {
            LottoErrorCode.UNAVAILABLE_TO_PURCHASE.message("$amount $manualLotteriesSize")
        }

        purchasedAutoLotteries = List(maximumAutoPurchaseQuantity) { LotteryGenerator.draw() }
            .run(::PurchasedLotteries)
    }

    fun purchasedLotteries(): PurchasedLotteries = purchasedManualLotteries + purchasedAutoLotteries

    constructor(amountText: String, manualLotteryTexts: List<String>) : this(
        amount = amountText.toInt(),
        purchasedManualLotteries = manualLotteryTexts.map(::Lottery)
            .run(::PurchasedLotteries),
    )

    companion object {
        private const val ZERO: Int = 0
    }
}
