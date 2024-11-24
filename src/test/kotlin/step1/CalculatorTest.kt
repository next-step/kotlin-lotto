package step1

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `쉼표 또는 콜론을 구분자로 가지는 문자열을 받는다`() {
        val sum = Calculator.sum("1,2")

        assertThat(sum).isEqualTo(3)
    }

    @Test
    fun `쉼표 또는 콜론이 아닌 다른 구분자의 경우 오류를 발생한다`() {
        assertThatThrownBy { Calculator.sum("1&2") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자로 변환할 수 없습니다.")
    }
}
