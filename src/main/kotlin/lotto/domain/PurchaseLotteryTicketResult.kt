package lotto.domain

sealed class PurchaseLotteryTicketResult {

    data class SUCCESS(
            val lotteryTickets: LotteryTickets,
            val manualLotteryTicketQuantity: Int,
            val autoLotteryTicketQuantity: Int
    ): PurchaseLotteryTicketResult()
    data class FAIL(val exception: Exception): PurchaseLotteryTicketResult()
}
