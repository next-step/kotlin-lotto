package lotto.provider

import lotto.domain.LottoProfitResult
import lotto.domain.LottoResult
import lotto.domain.LottoTickets
import lotto.domain.WinResult
import lotto.domain.WinningNumber

object LottoResultProvider {
    fun provideLottoResult(
        lottoTickets: LottoTickets,
        winningNumber: WinningNumber,
        totalTicketPurchasePrice: Int,
        remainder: Int
    ): LottoResult {
        val winResult = WinResult(lottoTickets, winningNumber)
        val totalPrize = winResult.totalPrizeWon

        val lottoProfitResult = LottoProfitResult(
            totalTicketPrice = totalTicketPurchasePrice,
            totalPrize = totalPrize,
            remainder = remainder
        )

        return LottoResult(
            lottoProfitResult = lottoProfitResult,
            netSpent = totalTicketPurchasePrice,
        )
    }
}
