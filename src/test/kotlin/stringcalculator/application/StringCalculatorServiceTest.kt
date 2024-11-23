package stringcalculator.application

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorServiceTest {
    @ParameterizedTest
    @CsvSource(
        "'', 0",
        "'0', 0",
        "'1', 1",
        "'1,2', 3",
        "'1;2', 3",
        "'1;2,3', 6",
    )
    fun `기분 구분자의 문자열 계산기 기능을 확인한다`(
        str: String,
        result: Int,
    ) {
        StringCalculatorService.calculate(str) shouldBe result
    }

    @ParameterizedTest
    @CsvSource(
        "'//a\n1a2a3', 6",
        "'//a\n1a2', 3",
        "'//,\n1,3', 4",
        "'//;\n1;4', 5",
        "'//;\n1;5', 6",
        "'//a\n1a2,3;4', 10",
    )
    fun `커스텀 구분자의 문자열 계산기 기능을 확인한다`(
        str: String,
        result: Int,
    ) {
        StringCalculatorService.calculate(str) shouldBe result
    }
}
