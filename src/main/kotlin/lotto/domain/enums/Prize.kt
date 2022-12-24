package lotto.domain.enums

import lotto.common.value.Money
import lotto.common.value.Money.Companion.toMoney

enum class Prize(
    val equalNumberCount: Long = 0,
    val amount: Money = 0L.toMoney(),
    val bonus: Boolean = false
) {
    BOOM,
    FIFTH(3, 5_000L.toMoney()),
    FOURTH(4, 50_000L.toMoney()),
    THIRD(5, 1_500_000L.toMoney()),
    SECOND(5, 30_000_000L.toMoney(), bonus = true),
    FIRST(6, 2_000_000_000L.toMoney());

    fun isNotBoom(): Boolean = this != BOOM

    companion object {
        fun find(equalNumberCount: Long, hasBonusNumber: Boolean): Prize {
            return values().find { it.equalNumberCount == equalNumberCount && it.bonus == hasBonusNumber } ?: BOOM
        }
    }
}
