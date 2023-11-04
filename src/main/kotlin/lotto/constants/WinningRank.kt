package lotto.constants

enum class WinningRank(
    val count: Int,
    val money: Int,
    private val matchBonus: Boolean = false,
    val find: (Int, Boolean) -> Boolean = { a, b -> count == a && matchBonus == b }
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0)
    ;

    companion object {
        fun of(count: Int, matchBonus: Boolean = false): WinningRank {
            return values().find { it.find(count, matchBonus) } ?: MISS
        }
    }
}
