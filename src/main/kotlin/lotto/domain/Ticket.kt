package lotto.domain

class Ticket(
    val numbers: List<Int> = buildList { repeat(TicketPolicy.LOTTO_COUNT) { add(TicketPolicy.generateNumber()) } }.sorted()
)
