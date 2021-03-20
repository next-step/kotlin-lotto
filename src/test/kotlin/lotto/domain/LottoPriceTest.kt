package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoPriceTest {
    @ParameterizedTest
    @ValueSource(ints = [500, 10, 0, 50, 100, 99, 999])
    fun `최소금액 1000원 만족 못할시 예외`() {
        assertThrows<IllegalArgumentException> {
            LottoPrice(0)
        }
    }
}