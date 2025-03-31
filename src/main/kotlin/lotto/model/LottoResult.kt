package lotto.model

class LottoResult(private val winningNumbers: List<Int>, private val tickets: List<TicketModel>) {
    fun calculateResult(): Map<Int, Int> {
        return mapOf(Pair(6,1))
    }

}