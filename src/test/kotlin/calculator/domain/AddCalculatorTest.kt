package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AddCalculatorTest {

    @Test
    fun `쉽표, 콜론으로 구분하여 수의 합을 반환한다`() {
        val input = "1:2,3:4"

        val addCalculator = AddCalculator()
        val answer = addCalculator.sum(input)

        val expect = 10
        assertThat(answer).isEqualTo(expect)
    }

    @Test
    fun `숫자 하나만 들어오면 해당 숫자 반환`() {
        val input = "1"
        val addCalculator = AddCalculator()
        val answer = addCalculator.sum(input)
        val expect = 1

        assertThat(answer).isEqualTo(expect)
    }

    @Test
    fun `빈 문자열이 들어오면 0 반환`() {
        val input = ""
        val addCalculator = AddCalculator()
        val answer = addCalculator.sum(input)
        val expect = 0

        assertThat(answer).isEqualTo(expect)
    }

    @Test
    fun `null 문자열이 들어오면 0 반환`() {
        val input: String? = null
        val addCalculator = AddCalculator()
        val answer = addCalculator.sum(input)
        val expect = 0

        assertThat(answer).isEqualTo(expect)
    }

    @Test
    fun `커스텀 구분자의 sum 테스트`() {
        val input = "//;\n1;2;3"
        val addCalculator = AddCalculator()
        val answer = addCalculator.sum(input)
        val expect = 6
        assertThat(answer).isEqualTo(expect)
    }
}
