package lotto.model

const val MINIMUM_MATCHES = 3

class LottoResult(private val winningNumbers: List<Int>, private val tickets: List<TicketModel>) {
    fun calculateResult(): Map<Int, Int> {
        return tickets.groupingBy { ticket ->
            ticket.numbers.count { it in winningNumbers }
        }
            .eachCount()
            .filterKeys { it >= MINIMUM_MATCHES }
    }

    fun totalPrize(): Int{
        val prizeMap = mapOf(
            3 to 5_000,
            4 to 50_000,
            5 to 1_500_000,
            6 to 2_000_000_000
        )

        return calculateResult().entries.sumOf { (matchCount, count) ->
            prizeMap[matchCount]?.times(count) ?: 0
        }
    }

    fun returnRate(purchaseAmount: Int): Double {
        return if (purchaseAmount == 0) 0.0 else totalPrize().toDouble() / purchaseAmount
    }
}