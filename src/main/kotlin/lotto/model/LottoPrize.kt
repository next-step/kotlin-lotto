package lotto.model

import lotto.model.Money.Companion.ZERO
import lotto.model.Money.Companion.of

enum class LottoPrize(
    val matchCount: Int,
    val winningAmount: Money,
    val matchBonus: Boolean? = null
) {
    FIRST(6, of(2_000_000_000)),
    SECOND(5, of(30_000_000), matchBonus = true),
    THIRD(5, of(1_500_000), matchBonus = false),
    FOURTH(4, of(50_000)),
    FIFTH(3, of(5_000)),
    NONE(0, ZERO);

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): LottoPrize {
            return values().filter { it.matchCount == matchCount }
                .find { it.matchBonus?.equals(matchBonus) ?: true } ?: NONE
        }
    }
}
