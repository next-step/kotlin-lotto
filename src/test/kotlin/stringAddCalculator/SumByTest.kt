package stringAddCalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SumByTest {
    @ParameterizedTest
    @CsvSource(value = ["1,2,3", "1,3,5", "6,1,7"])
    fun `숫자 리스트로부터 모든 숫자의 합을 얻을 수 있다`(number1: Int, number2: Int, number3: Int) {
        val numbers = listOf<Int>(number1, number2, number3)
        val expected = number1 + number2 + number3
        Assertions.assertThat(sumBy(numbers)).isEqualTo(expected)
    }
}
