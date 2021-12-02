package lotto.domain

/**
 *
 * @author Leo
 */
class DashBoard {

    fun result(winningNumbers: List<Int>, tickets: List<Ticket>): Map<Rank, List<Ticket>> {
        return tickets.groupBy { it.getRank(winningNumbers) }
    }

    fun earnings(result: Map<Rank, List<Ticket>>, amount: Int): Double {
        val prize = getPrize(result)
        return prize.div(amount.toDouble())
    }

    private fun getPrize(result: Map<Rank, List<Ticket>>): Int {
        var prize = 0
        result.forEach { (rank, tickets) -> prize += rank.prize * tickets.size }

        return prize
    }

}
