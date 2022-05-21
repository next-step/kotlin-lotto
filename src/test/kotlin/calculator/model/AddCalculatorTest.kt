package calculator.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("덧셈 계산기 테스트")
class AddCalculatorTest {

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        " = 0",
        "1 = 1",
        "1,2 = 3",
        "3,4:5 = 12",
        delimiter = '='
    )
    fun `덧셈을 정상적으로 계산`(input: String?, result: Int) {
        // when, then
        assertEquals(AddCalculator.calculate(input), result)
    }

    @Test
    fun `커스텀 구분자를 지정했을 때 덧셈을 정상적으로 계산`() {
        // given
        val input = "//;\n1;2;3"

        // when, then
        assertEquals(AddCalculator.calculate(input), 6)
    }
}
