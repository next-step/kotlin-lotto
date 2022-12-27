package lotto.domain

class IssuanceTickets(private val _tickets: List<Ticket>) {

    val tickets: List<Ticket>
        get() = _tickets
}
