package lotto.constants

enum class WinningRank(val count: Int, val money: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0),
    ;

    companion object {
        fun of(count: Int): WinningRank {
            return values().find { it.count == count } ?: MISS
        }
    }
}
