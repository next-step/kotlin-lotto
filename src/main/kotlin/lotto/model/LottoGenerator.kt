package lotto.model

class LottoGenerator {

    companion object {
        fun generateTickets(count: Int, length: Int, range: IntRange) = List(count) { Ticket(length, range) }
    }
}
