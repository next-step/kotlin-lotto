package lotto.domain

enum class Winning(val winningAmount: Int, val matchCount: Int) {
    FIFTH_PLACE(5_000, 3),
    FOURTH_PLACE(50_000, 4),
    THIRD_PLACE(1_500_000, 5),
    SECOND_PLACE(30_000_000, 5),
    FIRST_PLACE(2_000_000_000, 6),
    LOSE(0, 0);

    companion object {
        fun of(count: Int, matchBonus: Boolean): Winning {
            return if (count == SECOND_PLACE.matchCount) {
                if (matchBonus) SECOND_PLACE else THIRD_PLACE
            } else {
                values().find { count == it.matchCount } ?: LOSE
            }
        }
    }
}
