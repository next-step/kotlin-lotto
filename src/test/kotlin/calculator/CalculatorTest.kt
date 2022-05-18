package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    @Test
    fun `빈 문자열은 0을 반환`() {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.add("")

        // then
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `콤마 구분자`() {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.add("1,2,3")

        // then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `세미콜론 구분자`() {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.add("1:2:3")

        // then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `다른 종류의 구분자`() {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.add("1:2,3")

        // then
        assertThat(result).isEqualTo(6)
    }
}
