package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class NumberTest {

    @Test
    fun `숫자 외의 값으로 Number 생성시 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Number("a")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1234", "0"])
    fun `양수 또는 0 숫자 생성`(num: String) {
        val number = Number(num)
        assertThat(number.value).isEqualTo(num.toInt())
        assertThat(number.isPositiveOrZero).isTrue()
    }

    @Test
    fun `음수 숫자 생성`() {
        val number = Number("-123")
        assertThat(number.value).isEqualTo(-123)
        assertThat(number.isPositiveOrZero).isFalse()
    }
}
