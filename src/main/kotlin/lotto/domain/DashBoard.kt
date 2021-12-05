package lotto.domain

/**
 *
 * @author Leo
 */
class DashBoard {

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
