package lotto.model

class LottoValidator {
    companion object {
        fun validate(tickets: List<Ticket>, winningNumbers: List<Int>, ticketLength: Int): List<Int> {
            val result = MutableList(ticketLength + 1) { 0 }
            tickets.forEach {
                result[it.matchCount(winningNumbers)]++
            }
            return result.toList()
        }
    }
}
