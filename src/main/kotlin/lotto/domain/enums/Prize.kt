package lotto.domain.enums

import lotto.common.value.Money
import lotto.common.value.Money.Companion.toMoney

enum class Prize(
    val amount: Money = 0L.toMoney(),
    private val condition: PrizeCondition
) {
    FIRST(2_000_000_000L.toMoney(), PrizeCondition.FIRST_CONDITION),
    SECOND(30_000_000L.toMoney(), PrizeCondition.SECOND_CONDITION),
    THIRD(1_500_000L.toMoney(), PrizeCondition.THIRD_CONDITION),
    FOURTH(50_000L.toMoney(), PrizeCondition.FOURTH_CONDITION),
    FIFTH(5_000L.toMoney(), PrizeCondition.FIFTH_CONDITION),
    BOOM(condition = PrizeCondition.BOOM_CONDITION);

    fun isNotBoom(): Boolean = this != BOOM
    fun equalNumberCount(): Long = this.condition.equalNumberCount
    fun isBonusPrize(): Boolean = this.condition.bonus

    companion object {
        fun find(equalNumberCount: Long, hasBonusNumber: Boolean): Prize {
            return values().find { it.condition.match(equalNumberCount, hasBonusNumber) } ?: BOOM
        }

        private enum class PrizeCondition(
            val equalNumberCount: Long = 0,
            val bonus: Boolean = false
        ) {
            BOOM_CONDITION,
            FIFTH_CONDITION(equalNumberCount = 3),
            FOURTH_CONDITION(equalNumberCount = 4),
            THIRD_CONDITION(equalNumberCount = 5),
            SECOND_CONDITION(equalNumberCount = 5, bonus = true),
            FIRST_CONDITION(equalNumberCount = 6);

            fun match(equalNumberCount: Long, hasBonusNumber: Boolean): Boolean {
                return if (this.bonus) equalNumberCount(equalNumberCount) && hasBonusNumber else equalNumberCount(equalNumberCount)
            }

            private fun equalNumberCount(equalNumberCount: Long) = this.equalNumberCount == equalNumberCount
        }
    }
}
