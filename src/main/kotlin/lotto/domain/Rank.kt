package lotto.domain

enum class Rank(val matchCount: Int, val prize: Int, val hasBonus: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 50_000),
    FOURTH(4, 5_000),
    FIFTH(3, 5_000),
    NONE(0, 0),
    ;

    companion object {
        fun from(
            matchCount: Int,
            matchBonus: Boolean = false,
        ): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && matchBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}
