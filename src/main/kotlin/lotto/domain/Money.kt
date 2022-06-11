package lotto.domain

import lotto.domain.LottoRule.LOTTO_PRICE
import java.math.BigDecimal
import java.math.RoundingMode

data class Money(private val amount: Int) {
    init {
        require(amount >= 0) {
            NEGATIVE_VALUE_MESSAGE
        }
    }

    val lottoCount: Int = amount / LOTTO_PRICE
    val currency = "${amount}원"

    operator fun div(money: Money): BigDecimal = BigDecimal(amount).divide(BigDecimal(money.amount), 2, RoundingMode.FLOOR)
    operator fun plus(money: Money): Money = Money(amount + money.amount)
    operator fun minus(money: Money): Money = Money(amount - money.amount)

    companion object {
        private const val NEGATIVE_VALUE_MESSAGE = "화폐는 음수일 수 없습니다."
    }
}
