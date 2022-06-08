package lotto.domain

import java.math.BigDecimal

private const val INITIAL_COUNT_NUMBER = 0

enum class Rank(
    val correctNumber: Int,
    val winningMoney: BigDecimal,
) {
    FIRST(6, BigDecimal(2_000_000_000)),
    SECOND(5, BigDecimal(1_500_000)),
    THIRD(4, BigDecimal(50_000)),
    FOURTH(3, BigDecimal(5_000)),
    NONE(0, BigDecimal.ZERO),
    ;

    companion object {
        fun of(correctNumber: Int): Rank = values().find { it.correctNumber == correctNumber }
            ?: NONE

        fun toResult(): MutableMap<Rank, Int> = values().associateWith { INITIAL_COUNT_NUMBER } as MutableMap<Rank, Int>
    }
}
