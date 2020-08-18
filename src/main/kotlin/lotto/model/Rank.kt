package lotto.model

enum class Rank(val match: Int, val price: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    ELSE(0, 0);

    companion object {
        fun of(matchCount: Int, isBonus: Boolean): Rank {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (isBonus) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> ELSE
            }
        }
    }
}
