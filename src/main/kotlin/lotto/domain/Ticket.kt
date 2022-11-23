package lotto.domain

class Ticket(
    private val numbers: List<Int> = buildList { repeat(TicketPolicy.LOTTO_COUNT) { add(TicketPolicy.generateNumber()) } }.sorted()
){

    fun getNumbers() = this.numbers
}
