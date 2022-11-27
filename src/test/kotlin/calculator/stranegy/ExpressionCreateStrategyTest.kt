package calculator.stranegy

import calculator.domain.SplitTerms
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ExpressionCreateStrategyTest {

    @Test
    fun `문자열 구분자를 제거하여 숫자만 있는 수식 만들기`() {
        // given
        val input = "//;\n1;2;3"
        val splitTerms = SplitTerms.create(input)

        // when
        val expression = ExpressionCreateStrategy.CALCULATOR_PLUS.create(input, splitTerms)
        val actual = expression.value

        // then
        val expected = "123"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `문자열 구분자 외 다른 문자가 포함되어 있어서 숫자만 있는 수식 생성 실패`() {
        assertThrows<IllegalArgumentException> {
            val input = "//;\n1;2;3dasd"
            val splitTerms = SplitTerms.create(input)

            ExpressionCreateStrategy.CALCULATOR_PLUS.create(input, splitTerms)
        }
    }
    
}