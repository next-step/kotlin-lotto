package lotto.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PurchaseAmountTest {
    @DisplayName("음수를 입력한 경우 예외 발생")
    @Test
    fun validateNegative() {
        assertThrows<IllegalArgumentException> { PurchaseAmount("-1") }
    }

    @DisplayName("로또 구매 금액을 나누어 떨어지게 입력하지 않은 경우 예외 발생")
    @Test
    fun validateUnit() {
        assertThrows<IllegalArgumentException> { PurchaseAmount("2500") }
    }

    @DisplayName("숫자가 아닌 문자를 입력한 경우 예외 발생")
    @Test
    fun init() {
        assertThrows<IllegalArgumentException> { PurchaseAmount("a") }
    }
}
