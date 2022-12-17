package lotto.domain.enums

import lotto.common.value.Money

enum class Prize(
    val equalNumberCount: Long = 0,
    val amount: Money = Money.from(0)
) {
    BOOM,
    THREE(3, Money.from(5_000)),
    FOUR(4, Money.from(50_000)),
    FIVE(5, Money.from(1_500_000)),
    SIX(6, Money.from(2_000_000_000));

    fun isNotBoom(): Boolean = this != BOOM

    companion object {
        fun find(equalNumberCount: Long): Prize {
            return values().find { it.equalNumberCount == equalNumberCount } ?: BOOM
        }
    }
}
