package lotto.domain

enum class LottoRank(val matchCount: Int, val prize: Int, matchBonus: Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5000, false),
    NONE(0, 0, false),
    ;

    companion object {
        fun from(matchCount: Int, matchBonus: Boolean): LottoRank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && matchBonus -> SECOND
                matchCount == 5 && !matchBonus -> THIRD
                else -> entries.find { it.matchCount == matchCount } ?: NONE
            }
        }
    }
}
