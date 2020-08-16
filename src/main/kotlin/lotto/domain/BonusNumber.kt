package lotto.domain

class BonusNumber(private val number: Int) {
    init {
        require(number in Ticket.TICKET_NUMBER_MIN..Ticket.TICKET_NUMBER_MAX)
    }

    fun match(ticket: Ticket): Boolean {
        return ticket.numbers.contains(number)
    }
}
