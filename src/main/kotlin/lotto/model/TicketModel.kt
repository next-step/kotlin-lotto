package lotto.model

const val TICKET_NUMBER_LENGTH = 6

class TicketModel(val numbers : List<Int>) {
    init {
        require(numbers.size == TICKET_NUMBER_LENGTH) {
            "Ticket should contain $TICKET_NUMBER_LENGTH numbers"
        }
    }

    companion object {
        fun generate(): TicketModel {
            return TicketModel((1..45).shuffled().take(6))
        }
    }
}