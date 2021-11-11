package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class MoneyTest {
    @Test
    fun `구입 금액은 양의 정수다`() {
        val input = "10000"
        val expected = input.toInt()
        assertThat(Money.of(input).value).isEqualTo(expected)
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = ["0", "-1000", "abc"])
    fun `구입 금액이 양의 정수가 아닌 경우 예외를 발생시킨다`(input: String?) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Money.of(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["100", "999"])
    fun `구입 금액이 1000원보다 낮은 값이 들어올 경우 예외를 발생시킨다`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Money.of(input) }
    }
}
