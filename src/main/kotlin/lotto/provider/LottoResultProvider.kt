package lotto.provider

import lotto.domain.LottoProfitResult
import lotto.domain.LottoPurchaseOrder
import lotto.domain.LottoResult
import lotto.domain.LottoTickets
import lotto.domain.WinningNumber

object LottoResultProvider {
    fun provideLottoResult(
        lottoTickets: LottoTickets,
        winningNumber: WinningNumber,
        purchaseOrder: LottoPurchaseOrder,
    ): LottoResult {
        val winResult = winningNumber.getResult(lottoTickets)
        val totalPrize = winResult.totalPrizeWon

        val lottoProfitResult = LottoProfitResult(
            totalTicketPrice = purchaseOrder.totalPrice,
            totalPrize = totalPrize,
            remainder = purchaseOrder.remainder
        )

        return LottoResult(
            lottoProfitResult = lottoProfitResult,
            netSpent = purchaseOrder.totalPrice,
        )
    }
}
