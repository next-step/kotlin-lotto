package lotto.domain

/**
 *
 * @author Leo
 */
data class Tickets(val tickets: List<Ticket>) {

    fun result(winningNumbers: List<Int>, bonusNumber: Int): Map<Rank, List<Ticket>> {
        return tickets.groupBy { it.getRank(winningNumbers, bonusNumber) }
    }

}
