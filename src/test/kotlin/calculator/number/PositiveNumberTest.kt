package calculator.number

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositiveNumberTest {
    @ParameterizedTest
    @ValueSource(strings = ["a", "1&2", ","])
    fun `숫자가 아닐 경우 RuntimeException 이 발생한다`(input: String) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { PositiveNumber.get(input) }
    }

    @Test
    fun `음수일 경우 RuntimeException 이 발생한다`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { PositiveNumber.get("-1") }
    }

    @Test
    fun `음수가 아닌 정수일 경우 해당 값의 int 값을 반환한다`() {
        val number = PositiveNumber.get("100")
        assertThat(number).isEqualTo(100)
    }
}
