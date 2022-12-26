package lotto.model

import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.math.BigDecimal.valueOf

enum class LottoPrize(
    val matchCount: Int,
    val winningAmount: BigDecimal,
    val matchBonus: Boolean? = null
) {
    FIRST(6, valueOf(2_000_000_000)),
    SECOND(5, valueOf(30_000_000), matchBonus = true),
    THIRD(5, valueOf(1_500_000), matchBonus = false),
    FOURTH(4, valueOf(50_000)),
    FIFTH(3, valueOf(5_000)),
    NONE(0, ZERO);

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): LottoPrize {
            return values().filter { it.matchCount == matchCount }
                .find { it.matchBonus?.equals(matchBonus) ?: true } ?: NONE
        }
    }
}
