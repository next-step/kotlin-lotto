package lotto.domain

import java.math.BigDecimal

enum class Rank(
    val correctNumber: Int,
    val winningMoney: BigDecimal,
) {
    FIRST(6, BigDecimal(2_000_000_000)),
    SECOND(5, BigDecimal(30_000_000)),
    THIRD(5, BigDecimal(1_500_000)),
    FOURTH(4, BigDecimal(50_000)),
    FIFTH(3, BigDecimal(5_000)),
    NONE(0, BigDecimal.ZERO),
    ;

    companion object {
        fun of(correctNumber: Int, isMatchedBonusBall: Boolean): Rank {
            if (correctNumber == 5 && !isMatchedBonusBall) {
                return THIRD
            }

            return values().find { it.correctNumber == correctNumber }
                ?: NONE
        }
    }
}
