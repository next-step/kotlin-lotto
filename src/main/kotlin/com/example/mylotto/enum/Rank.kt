package com.example.mylotto.enum

enum class Rank(
    val countOfMatch: Int,
    val winningMoney: Int,
) {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    companion object {
        fun valueOf(countOfMatch: Int): Rank =
            when (countOfMatch) {
                6 -> FIRST
                5 -> THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> MISS
            }
    }
}
