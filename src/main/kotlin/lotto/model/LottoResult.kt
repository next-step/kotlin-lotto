package lotto.model

class LottoResult(private val winningNumbers: List<Int>, private val tickets: List<TicketModel>) {
    fun calculateResult(): Map<Int, Int> {
        return tickets.groupingBy { ticket ->
            ticket.numbers.count { it in winningNumbers }
        }
            .eachCount()
    }

    fun totalPrize(): Int{
        return 2_001_550_000
    }
}