package lotto.domain

enum class Rank(val countOfMatch: Int, private val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    fun prize(count: Int): Int {
        return winningMoney * count
    }

    companion object {
        fun valueOf(
            countOfMatch: Int,
            matchBonus: Boolean,
        ): Rank {
            return entries.find {
                countOfMatch == it.countOfMatch &&
                    ((it != SECOND) || matchBonus)
            } ?: MISS
        }
    }
}
