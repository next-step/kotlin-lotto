package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class MoneyTest {

    @ParameterizedTest(name = "`{0}`인 경우 IllegalArgumentException 에러 발생")
    @ValueSource(ints = [-3, -7])
    internal fun `입력한 값이 0원 미만이면 IllegalArgumentException 에러 발생`(price: Int) {
        assertThrows<IllegalArgumentException> { Money(price) }
    }

    @ParameterizedTest(name = "`{0}`인 경우 Money 생성 성공")
    @ValueSource(ints = [1000, 1500, 30000])
    internal fun `입력한 값이 0원 이상이면 Money 생성 성공`(price: Int) {
        assertDoesNotThrow { Money(price) }
    }

    @Test
    internal fun `int값으로 나누기를 할 수 있다`() {
        val actual = Money(10) / 2
        assertThat(actual).isEqualTo(5)
    }

    @Test
    internal fun `int값과 곱하기를 할 수 있다`() {
        val actual = Money(10) * 2
        assertThat(actual).isEqualTo(20)
    }

    @Test
    internal fun `int값과 비교 할 수 있다`() {
        val actual = Money(10) > 2
        assertThat(actual).isTrue
    }
}
