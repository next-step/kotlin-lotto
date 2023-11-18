package lotto.domain

enum class Rank(val countOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    fun calculateTotal(ticketCount: Int): Int {
        return winningMoney * ticketCount
    }

    companion object {
//        fun valueOf(countOfMatch: Int, matchBonus: Boolean): Rank {
//            return values().find {
//
//            }
//        }

        fun from(count: Int): Rank {
            return values().find { it.countOfMatch == count } ?: MISS
        }
    }
}