package lotto.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoPriceTest {
    @DisplayName("로또 가격을 나누어 떨어지게 입력하지 않은 경우 예외 발생")
    @Test
    fun validateUnit() {
        assertThrows<IllegalArgumentException> { LottoPrice(2500) }
    }
}
