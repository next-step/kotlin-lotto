package lotto

enum class Winning(val matchCount: Int, val winningAmount: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    FAIL(0, 0);

    companion object {
        fun of(count: Int): Winning {
            return Winning.values().find { it.matchCount == count } ?: FAIL
        }
    }
}
