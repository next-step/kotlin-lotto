package calculator.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("덧셈 계산기 테스트")
class AddCalculatorTest {

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        "1 = 1",
        "1 + 2 = 3",
        "1 + 2 + 3 = 6",
        delimiter = '='
    )
    fun `덧셈을 정상적으로 계산`(expression: String, result: Int) {
        // given
        val numbers = expression.split("+")
            .map { it.trim().toInt() }

        // when, then
        assertEquals(AddCalculator(numbers), Number.from(result))
    }
}
