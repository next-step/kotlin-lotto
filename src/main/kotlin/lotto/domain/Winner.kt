package lotto.domain

class Winner(private val numbers: List<Int>) {

    constructor(expression: String) : this(expression.split(",").map { it.toInt() })

    fun getWinnerNumbers() = this.numbers

    fun checkNumberMatch(tickets: List<Ticket>) = initRewardMatching().also {
        tickets.forEach { ticket ->
            Reward.find(ticket.getMatchingNumbersCount(numbers))
                ?.also { reward -> it[reward] = (it[reward] ?: 0) + 1 }
        }
    }

    private fun initRewardMatching() = Reward.values().associateWith { 0 }.toMutableMap()
}
