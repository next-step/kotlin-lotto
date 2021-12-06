package lotto.domain

enum class Prize(val money: Int, val matchCount: Int) {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NONE(0, 0);

    companion object {
        fun findPrize(count: Int, matchBonus: Boolean): Prize {
            return if (count == 5 && !matchBonus) {
                THIRD
            } else {
                values().find { it.matchCount == count } ?: NONE
            }
        }
    }
}
