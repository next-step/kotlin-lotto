package stringaddcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import stringaddcalculator.domain.StringAddCalculator
import stringaddcalculator.domain.Number

class StringAddCalculatorTest {

    @Test
    fun `문자열List를 넣으면 덧셈 결과가 나오는지 확인`() {
        // given
        val strings = listOf("1", "2", "3")

        // then
        assertThat(StringAddCalculator.calculate(strings)).isEqualTo(Number(6))
    }

    @Test
    fun `빈 리스트 입력시 0반환`() {
        // then
        assertThat(StringAddCalculator.calculate(emptyList())).isEqualTo(Number(0))
    }
}
