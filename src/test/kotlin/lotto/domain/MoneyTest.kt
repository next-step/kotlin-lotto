package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class MoneyTest {

    @Test
    fun `0보다 작은 금액 대한 에러 확인`() {
        assertThrows<IllegalArgumentException> { Money(-1) }
    }

    @ParameterizedTest
    @CsvSource("0", "100")
    fun `0 또는 0 보다 큰 금액에 대한 확인`(amount: Int) {
        assertThat(Money(amount)).isEqualTo(Money(amount))
    }
}
