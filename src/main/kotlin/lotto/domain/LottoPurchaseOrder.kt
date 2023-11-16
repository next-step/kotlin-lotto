package lotto.domain

data class LottoPurchaseOrder(
    val budget: Int,
    val ticketPrice: Int,
) {
    val ticketCount = budget / ticketPrice
    val totalPrice: Int = ticketPrice * ticketCount
    val remainder: Int = budget - totalPrice
}
