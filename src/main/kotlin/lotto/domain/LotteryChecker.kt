package lotto.domain

class LotteryChecker(
    private val winningNumber: List<LotteryNumber>,
    private val lotteries: List<Lottery>
) {

    fun run(): Map<Rank, Int> {
        val matches = calculateMatches()
        return Rank.values().associateWith { rank ->
            matches[rank.matches] ?: 0
        }
    }

    private fun calculateMatches(): Map<Int, Int> =
        lotteries.groupingBy { ticket ->
            ticket.calculateMatch(winningNumber)
        }.eachCount()
}
