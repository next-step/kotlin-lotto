package calculator.model.operator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class AddOperatorTest {
    @ParameterizedTest
    @CsvSource(
        "1+2=3",
        "3+6=9",
        "10+5=15",
        "20+10=30",
    )
    fun `입력받은 두 값의 합을 계산`(input: String) {
        val parts = input.split('=')
        val numbers = parts[0].split('+').map { it.toInt() }
        val result = parts[1].toInt()
        val operator = AddOperator()
        assertThat(operator.apply(numbers[0], numbers[1]))
            .isEqualTo(result)
    }
}
