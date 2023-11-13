package lotto.domain

data class LottoPurchaseOrder(
    val budget: Int,
    val ticketPrice: Int,
    val ticketCount: Int,
) {
    val totalPrice: Int = ticketPrice * ticketCount
    val remainder: Int = budget - totalPrice
}
