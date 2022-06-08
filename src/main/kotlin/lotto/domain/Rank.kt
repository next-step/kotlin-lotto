package lotto.domain

import java.math.BigDecimal

enum class Rank(
    private val correctNumber: Int,
    private val winningMoney: BigDecimal,
) {
    FIRST(6, BigDecimal.valueOf(2_000_000_000)),
    SECOND(5, BigDecimal.valueOf(1_500_000)),
    THIRD(4, BigDecimal.valueOf(50_000)),
    FORTH(3, BigDecimal.valueOf(5_000)),
    NONE(0, BigDecimal.ZERO),
    ;

    companion object {
        fun of(correctNumber: Int): Rank = values().find { it.correctNumber == correctNumber }
            ?: NONE
    }
}
