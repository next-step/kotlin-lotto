package lotto.domain

enum class Match(val prize: Int) {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    BONUS(30000000),
    SIX(2000000000),
    NONE(0);

    companion object {
        fun valueOf(count: Int, isBonus: Boolean): Match {
            return when (count) {
                3 -> THREE
                4 -> FOUR
                5 -> if (isBonus) BONUS else FIVE
                6 -> SIX
                else -> NONE
            }
        }
    }
}
