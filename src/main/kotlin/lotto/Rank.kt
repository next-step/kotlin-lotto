package lotto

enum class Rank(private val match: Int, private val price: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    ELSE(0, 0);

    companion object {
        fun of(matchCount: Int, isBonus: Boolean): Rank {
            if (matchCount == 6) {
                return FIRST
            }
            if (matchCount == 5 && isBonus) {
                return SECOND
            }
            if (matchCount == 5) {
                return THIRD
            }
            if (matchCount > 2) {
                return values().first { it.match == matchCount }
            }
            return ELSE
        }
    }
}
