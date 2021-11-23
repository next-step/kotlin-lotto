package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
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

    @Test
    fun `덧셈과 곱셉이 가능하다`() {
        val money = Money.of(100)
        val other = Money.of(200)
        val expected = Money.of(300)
        assertAll(
            { assertThat(money + other).isEqualTo(expected) },
            { assertThat(money * 3).isEqualTo(expected) }
        )
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = ["-1000", "abc"])
    fun `구입 금액이 양의 정수가 아닌 경우 예외를 발생시킨다`(input: String?) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Money.of(input) }
    }
}
