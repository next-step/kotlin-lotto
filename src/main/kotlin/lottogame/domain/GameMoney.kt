package lottogame.domain

import java.math.BigDecimal

@JvmInline
value class GameMoney(val value: BigDecimal) {
    init {
        require(value >= MIN_MONEY) { "금액은 ${MIN_MONEY}원 이상이어야 합니다. [${value}]" }
        require(value % MONEY_UNIT == BigDecimal.ZERO) { "금액은 ${MONEY_UNIT}원 단위로 입력해야 합니다. [${value}]" }
    }

    fun calculatePurchaseCount(): Int {
        return value.divide(MONEY_UNIT).toInt()
    }

    companion object {
        private val MONEY_UNIT = 1_000.toBigDecimal()
        private val MIN_MONEY = 1_000.toBigDecimal()

        fun from(value: Int): GameMoney {
            return GameMoney(value.toBigDecimal())
        }
    }
}
