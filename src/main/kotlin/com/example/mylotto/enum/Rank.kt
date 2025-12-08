package com.example.mylotto.enum

enum class Rank(
    val winningMoney: Int,
    val countOfMatch: Int,
    val isBonusMatched: Boolean = false,
) {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    MISS(0, 0),
    ;

    companion object {
        fun valueOf(
            countOfMatch: Int,
            isBonusMatched: Boolean,
        ): Rank =
            when (countOfMatch) {
                6 -> FIRST
                5 -> if (isBonusMatched) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> MISS
            }
    }
}
