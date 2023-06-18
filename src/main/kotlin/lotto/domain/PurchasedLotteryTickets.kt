package lotto.domain

class PurchasedLotteryTickets(val lotteryTickets: LotteryTickets) {
    val manualLotteryTicketQuantity: Int
    val autoLotteryTicketQuantity: Int
    val totalPurchasedLotteryTicketsQuantity: Int

    init {
        val (autos, manuals) = lotteryTickets.partition { it.isAuto }
        manualLotteryTicketQuantity = manuals.size
        autoLotteryTicketQuantity = autos.size
        totalPurchasedLotteryTicketsQuantity = lotteryTickets.size
    }
}
