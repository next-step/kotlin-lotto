package lotto.constants

enum class WinningRank(
    val count: Int,
    val money: Int,
    private val matchBonus: Boolean = false,
    val find: (Int, Boolean) -> Boolean = { a, b -> count == a && matchBonus == b }
) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0)
    ;

    companion object {
        fun of(count: Int, matchBonus: Boolean = false): WinningRank {
            return values().find { it.find(count, matchBonus) } ?: MISS
        }
    }
}
