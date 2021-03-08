package lotto

class LottoTicket(val count: Int) {
    constructor(money: Money) : this(money / TicketAmount().money)
}
