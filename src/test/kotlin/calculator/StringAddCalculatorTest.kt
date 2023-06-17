package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringAddCalculatorTest {

    @Test
    fun `쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다`() {
        // given
        val stringNumbers = "1;2,3"
        val expectResult = 1 + 2 + 3

        // when
        val result = StringAddCalculator().calculate(stringNumbers)

        // then
        assertThat(result).isEqualTo(expectResult)
    }
}
