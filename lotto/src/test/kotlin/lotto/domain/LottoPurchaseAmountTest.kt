package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoPurchaseAmountTest {
    @Nested
    inner class ValidateTest {
        @ParameterizedTest
        @ValueSource(ints = [1000, 2000, 3000, 4000])
        fun `로또 1장의 최소 구매금액은 1000원이다`(purchaseAmount: Int) {

        }

        @Test
        fun `로또 1장의 구매금액의 최소 단위는 1000원이다`() {
        }
    }
}
