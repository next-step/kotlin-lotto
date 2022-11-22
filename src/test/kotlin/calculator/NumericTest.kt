package calculator

import calculator.Numeric.Companion.validCheck
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumericTest {

    @Test
    fun `문자열에서 숫자를 추출한다`() {
        val expressions = listOf("1", "2", "3")
        assertThat(Numeric.convertNumeric(expressions)).isEqualTo(listOf(1, 2, 3))
    }

    @Test
    fun `문자열에서 숫자가 아니어도 추출한다`() {
        val expressions = listOf("1", "number", "3")
        assertThat(Numeric.convertNumeric(expressions)).isEqualTo(listOf(1, null, 3))
    }

    @Test
    fun `문자열에서 숫자가 없으면 0을 반환한다`() {
        val expressions = emptyList<String>()
        assertThat(Numeric.convertNumeric(expressions)).isEqualTo(listOf(0))
    }

    @Test
    fun `문자열에서 숫자를 하나면 반환한다`() {
        val expressions = listOf("1")
        assertThat(Numeric.convertNumeric(expressions)).isEqualTo(listOf(1))
    }

    @Test
    fun `문자열에서 숫자가 아닌 값이 있으면 에러가 발생한다`() {
        val expressions = Numeric.convertNumeric(listOf("1", "number", "3"))
        assertThrows<RuntimeException> { expressions.validCheck() }
    }

    @Test
    fun `문자열에서 마이너스 숫자가 있으면 에러가 발생한다`() {
        val expressions = Numeric.convertNumeric(listOf("1", "-2", "3"))
        assertThrows<RuntimeException> { expressions.validCheck() }
    }
}
