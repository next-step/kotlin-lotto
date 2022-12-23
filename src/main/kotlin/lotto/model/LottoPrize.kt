package lotto.model

import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.math.BigDecimal.valueOf

enum class LottoPrize(
    val matchCount: Int,
    val winningAmount: BigDecimal
) {
    FIRST(6, valueOf(2_000_000_000)),
    SECOND(5, valueOf(30_000_000)),
    THIRD(5, valueOf(1_500_000)),
    FOURTH(4, valueOf(50_000)),
    FIFTH(3, valueOf(5_000)),
    NONE(0, ZERO);

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): LottoPrize {
            if (matchCount == SECOND.matchCount && matchBonus) {
                return SECOND
            }

            return values().filterNot { it == SECOND }
                .find { it.matchCount == matchCount } ?: NONE
        }
    }
}
