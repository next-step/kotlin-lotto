package lotto.domain

data class LottoTicket(val count: Int) {
    constructor(money: Money) : this(money / TicketAmount().money)
}
