package lotto.provider

import lotto.domain.LottoProfitResult
import lotto.domain.LottoPurchaseOrder
import lotto.domain.LottoResult

object LottoResultProvider {
    fun provideLottoResult(
        totalPrize: Long,
        purchaseOrder: LottoPurchaseOrder,
    ): LottoResult {
        val lottoProfitResult = LottoProfitResult(
            totalTicketPrice = purchaseOrder.totalPrice,
            totalPrize = totalPrize,
            remainder = purchaseOrder.remainder
        )

        return LottoResult(
            lottoProfitResult = lottoProfitResult,
        )
    }
}
