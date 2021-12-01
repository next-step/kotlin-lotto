package lotto.domain

enum class Prize(val money: Int, val matchCount: Int) {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3),
    NONE(0, 0);

    companion object {
        fun findPrize(count: Int): Prize {
            return values().find { it.matchCount == count } ?: NONE
        }
    }
}
