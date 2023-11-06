package lotto.constants

enum class WinningRank(
    val count: Int,
    val money: Int,
    val matchBonus: Boolean = false
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0)
    ;

    fun find(count: Int, matchBonus: Boolean = false): Boolean {
        return this.count == count && this.matchBonus == matchBonus
    }

    companion object {
        fun of(count: Int, matchBonus: Boolean): WinningRank {
            if (count == SECOND.count) {
                return values().find { it.find(count, matchBonus) } ?: MISS
            }
            return values().find { it.find(count) } ?: MISS
        }
    }
}
