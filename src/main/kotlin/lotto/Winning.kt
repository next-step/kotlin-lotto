package lotto

enum class Winning(val winningAmount: Int, val matchCount: Int) {
    FOURTH_PLACE(5_000, 3),
    THIRD_PLACE(50_000, 4),
    SECOND_PLACE(1_500_000, 5),
    FIRST_PLACE(2_000_000_000, 6),
    LOSE(0, 0);

    companion object {
        fun of(count: Int): Winning = values().find { count == it.matchCount } ?: LOSE
    }
}
