package lotto.model

const val TICKET_NUMBER_LENGTH = 6

data class TicketModel(val numbers : List<Int>) {
    init {
        require(numbers.size == TICKET_NUMBER_LENGTH) {
            "Ticket should contain $TICKET_NUMBER_LENGTH numbers"
        }
    }

    companion object {
        fun generate(generator: TicketNumberGenerator): TicketModel {
            return TicketModel(generator.generateNumbers())
        }
    }
}