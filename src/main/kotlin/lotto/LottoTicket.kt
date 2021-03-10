package lotto

data class LottoTicket(val count: Int) {
    constructor(money: Money) : this(money / TicketAmount().money)
}
