package lotto.domain

class IssuanceTickets(private val tickets: List<Ticket>) {
    fun checkWinner(numbers: Numbers) {
        MatchInfo().also {
            tickets.forEach { ticket ->
                Reward.find(ticket.getMatchingNumbersCount(numbers))
                    ?.also { reward -> it.matchInfo[reward] = (it.matchInfo[reward] ?: 0) + 1 }
            }
        }
    }
}
