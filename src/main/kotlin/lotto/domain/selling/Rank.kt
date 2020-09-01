package lotto.domain.selling

enum class Rank(
    val matchCount: Int,
    val prizeMoney: Int,
    val hasBonus: Boolean = false
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        private val RANKS: Map<Int, Rank> = HashMap(values().associateBy { it.matchCount })

        operator fun invoke(matchCount: Int, bonus: Boolean): Rank = when {
            isSecond(matchCount, bonus) -> SECOND
            else -> RANKS[matchCount] ?: MISS
        }

        private fun isSecond(matchCount: Int, bonus: Boolean) =
            matchCount == SECOND.matchCount && bonus == SECOND.hasBonus
    }
}
