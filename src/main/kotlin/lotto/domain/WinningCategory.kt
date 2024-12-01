package lotto.domain

enum class WinningCategory(val matchCount: Int, val prize: Int, val requiresBonus: Boolean = false) {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, requiresBonus = true),
    FIRST(6, 2_000_000_000),
    ;

    companion object {
        fun fromMatchCount(
            count: Int,
            matchBonus: Boolean,
        ): WinningCategory {
            return entries
                .sortedByDescending { it.requiresBonus }
                .find {
                    it.matchCount == count && (if (it.requiresBonus) matchBonus else true)
                } ?: NONE
        }
    }
}
