package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class PaymentTest {
    @ParameterizedTest
    @CsvSource(
        value = [
            "1000:1",
            "2000:2",
            "13000:13",
        ],
        delimiter = ':',
    )
    fun `1000원으로 나눈 개수를 리턴한다`(
        amount: Long,
        expected: Int,
    ) {
        val payment = Payment.from(amount)
        payment.numberOfLines shouldBe expected
    }

    @ParameterizedTest
    @ValueSource(longs = [0, -1000, Long.MIN_VALUE])
    fun `금액이 0이거나 음수이면 예외를 던집니다`(amount: Long) {
        assertThrows<IllegalArgumentException> { Payment.from(amount) }
    }

    @Test
    fun `금액이 1000원 단위가 아니면 예외를 던집니다`() {
        assertThrows<IllegalArgumentException> { Payment.from(1500) }
    }
}
