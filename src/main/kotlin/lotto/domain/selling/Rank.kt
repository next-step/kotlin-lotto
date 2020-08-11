package lotto.domain.selling

enum class Rank(val matchCount: Int, val prizeMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        private val ranks: HashMap<Int, Rank> = HashMap(values().associateBy { it.matchCount })

        operator fun invoke(matchCount: Int, bonus: Boolean): Rank = when {
            isSecond(matchCount, bonus) -> SECOND
            else -> ranks[matchCount] ?: MISS
        }

        private fun isSecond(matchCount: Int, bonus: Boolean) = matchCount == SECOND.matchCount && bonus
    }
}
