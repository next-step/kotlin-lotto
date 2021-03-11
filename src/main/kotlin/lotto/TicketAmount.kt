package lotto

class TicketAmount(count: Int = 1) {
    val money: Money = Money(1_000 * count)
    val amount: Long = money.amount
}
