package lotto.domain

class Winner(private val numbers: List<Int>) {

    constructor(expression: String) : this(expression.split(",").map { it.toInt() })

    fun getWinnerNumbers() = this.numbers

    fun checkNumberMatch(tickets: List<Ticket>) = initRewardMatching().also {
        tickets.forEach { ticket ->
            Reward.find(countNumberMatching(ticket))
                .also { reward -> it[reward] = (it[reward] ?: 0) + 1 }
        }
    }

    private fun initRewardMatching() = Reward.values().map { it to 0 }.toMap(mutableMapOf())

    private fun countNumberMatching(ticket: Ticket) = ticket.getNumbers().filter { numbers.contains(it) }.size
}

enum class Reward(val count: Int) {
    `5000`(3), `50000`(4), `1500000`(5), `2000000000`(6);

    companion object {
        fun find(count: Int) =
            Reward.values().find { it.count == count }
                ?: throw IllegalArgumentException("Invalid Reward Count")
    }
}
