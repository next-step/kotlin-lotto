package lotto

enum class Rank(val matchCount: Int, val reward: Int) {

    ALL_MATCH(6, 2_000_000_000),
    FIVE_BONUS_MATCH(5, 30_000_000),
    FIVE_MATCH(5, 1_500_000),
    FOUR_MATCH(4, 50_000),
    THREE_MATCH(3, 5_000),
    NONE(0, 0);

    companion object {

        fun valueOf(matchCount: Int, matchBonus: Boolean): Rank {
            return when (matchCount) {
                5 -> if (matchBonus) FIVE_BONUS_MATCH else FIVE_MATCH
                else -> values().firstOrNull { it.matchCount == matchCount } ?: NONE
            }
        }
    }
}
