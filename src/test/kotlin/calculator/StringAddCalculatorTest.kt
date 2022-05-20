package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 을 입력할 경우 0 을 반환한다`(input: String?) {
        assertThat(StringAddCalculator.add(input)).isZero
    }

    @Test
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`() {
        assertThat(StringAddCalculator.add("3")).isEqualTo(3)
    }

    @Test
    fun `쉼표 구분자로 입력할 경우 두 숫자의 합을 반환한다`() {
        assertThat(StringAddCalculator.add("3,5")).isEqualTo(8)
    }

    @Test
    fun `콜론 구분자로 입력할 경우 두 숫자의 합을 반환한다`() {
        assertThat(StringAddCalculator.add("3:5")).isEqualTo(8)
    }

    @Test
    fun `쉽표, 콜론 구분자를 같이 입력할 경우에도 모든 숫자의 합을 반환하다`() {
        assertThat(StringAddCalculator.add("1,2:3")).isEqualTo(6)
    }

    @Test
    fun `커스텀 구분자를 지정할 수 있고 커스텀 구분자로 구분 된 숫자의 합을 반환한다`() {
        assertThat(StringAddCalculator.add("//!\n1!2!3")).isEqualTo(6)
    }
}
