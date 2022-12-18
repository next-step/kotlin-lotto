package lotto.domain.enums

import lotto.common.value.Money
import lotto.common.value.Money.Companion.toMoney

enum class Prize(
    val equalNumberCount: Long = 0,
    val amount: Money = 0L.toMoney()
) {
    BOOM,
    THREE(3, 5_000L.toMoney()),
    FOUR(4, 50_000L.toMoney()),
    FIVE(5, 1_500_000L.toMoney()),
    SIX(6, 2_000_000_000L.toMoney());

    fun isNotBoom(): Boolean = this != BOOM

    companion object {
        fun find(equalNumberCount: Long): Prize {
            return values().find { it.equalNumberCount == equalNumberCount } ?: BOOM
        }
    }
}
