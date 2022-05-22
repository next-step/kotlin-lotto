package calculator.processor

import calculator.model.PositiveNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorProcessorTests {
    private lateinit var calculatorProcessor: CalculatorProcessor

    @BeforeEach
    fun setUp() {
        calculatorProcessor = CalculatorProcessor()
    }

    @ParameterizedTest(name = "`{0}`을 다 더하면 `{1}`을 반환한다.")
    @CsvSource(
        value =
        [
            "1,2,3 = 6.0",
            "1,2,3.1 = 6.1"
        ],
        delimiter = '='
    )
    fun `리스트 안의 숫자값의 총합을 반환한다`(str: String, expected: Double) {
        val actual = calculatorProcessor.add(positiveNumberList(str))
        assertThat(actual).isEqualTo(expected)
    }

    private fun positiveNumberList(str: String) =
        str.split(",").map {
            PositiveNumber(it.trim().toDouble())
        }
}
