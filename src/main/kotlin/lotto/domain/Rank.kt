package lotto.domain

enum class Rank(val count: Int, val reward: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    companion object {
        fun getValue(count: Int, hasBonus: Boolean): Rank {
            return when {
                count == 6 -> FIRST
                count == 5 && hasBonus -> SECOND
                count == 5 -> THIRD
                count == 4 -> FOURTH
                count == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}
