package lotto.constants

enum class WinningRank(val count: Int, val money: Int, val matchBonus: Boolean) {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    MISS(0, 0, false)
    ;

    companion object {
        fun of(count: Int, matchBonus: Boolean = false): WinningRank {
            return values().find { it.count == count && it.matchBonus == matchBonus } ?: MISS
        }
    }
}
