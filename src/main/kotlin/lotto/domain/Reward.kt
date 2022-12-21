package lotto.domain

enum class Reward(val match: Int, val reward: Int, val isBonus: Boolean = false) {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000, true),
    FIRST(6, 200000000);

    companion object {
        fun find(ticket: Ticket, numbers: Numbers) = Reward.values()
            .find { it.match == ticket.getMatchingNumbersCount(numbers) }
            ?.let {
                if (it.match == 5 && it.isBonus == ticket.getMatchingBonus(numbers)) SECOND
                else it
            }
    }
}
