package lotto.model

const val TICKET_NUMBER_LENGTH = 6

class TicketModel(val numbers : List<Int>) {
    init {
        require(numbers.size == TICKET_NUMBER_LENGTH) {
            "Ticket should contain $TICKET_NUMBER_LENGTH numbers"
        }
    }
}