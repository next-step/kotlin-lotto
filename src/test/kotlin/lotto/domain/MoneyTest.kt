package lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class MoneyTest {
    @ParameterizedTest
    @ValueSource(strings = ["900", "0"])
    fun `로또 구입 금액이 1천원 미만이면 IllegalArgumentException 예외가 발생한다`(money: Long) {
        assertThrows<IllegalArgumentException> {
            PaidMoney(money)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1900", "2001"])
    fun `로또 구입 금액이 1천원 이상인데, 천단위가 아니면 IllegalArgumentException 예외가 발생한다`(money: Long) {
        assertThrows<IllegalArgumentException> {
            PaidMoney(money)
        }
    }
}
