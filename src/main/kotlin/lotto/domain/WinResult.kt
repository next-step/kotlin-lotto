package lotto.domain

enum class WinResult(val matchCount: Int, val reward: Long, val matchBonus: Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    LOSE(0, 0, false),
    ;

    companion object {
        fun valueOf(matchCount: Int, matchBonus: Boolean): WinResult {
            return values().firstOrNull { matchCount == it.matchCount && matchBonus == it.matchBonus } ?: LOSE
        }
    }
}
