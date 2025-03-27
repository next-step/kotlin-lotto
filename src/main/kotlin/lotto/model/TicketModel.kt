package lotto.model

class TicketModel(val numbers : List<Int>) {
    init {
        require(numbers.size == 6)
    }
}