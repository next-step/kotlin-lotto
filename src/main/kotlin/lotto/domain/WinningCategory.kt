package lotto.domain

enum class WinningCategory(val matchCount: Int, val prize: Int) {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    ;

    companion object {
        fun fromMatchCount(
            count: Int,
            matchBonus: Boolean,
        ): WinningCategory {
            return when {
                count == FIRST.matchCount -> FIRST
                count == SECOND.matchCount && matchBonus -> SECOND
                count == THIRD.matchCount -> THIRD
                count == FOURTH.matchCount -> FOURTH
                count == FIFTH.matchCount -> FIFTH
                else -> NONE
            }
        }
    }
}
