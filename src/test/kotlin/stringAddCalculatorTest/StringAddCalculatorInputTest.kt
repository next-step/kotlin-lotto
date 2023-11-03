package stringAddCalculatorTest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import stringAddCalculator.StringAddCalculatorInput
import java.util.stream.Stream

class StringAddCalculatorInputTest {
    @ParameterizedTest
    @CsvSource(value = ["1,2,3?1,2,3"], delimiter = '?')
    fun `콤마를 구분자로 활용하여 문자열을 파싱`(
        text: String,
        @ConvertWith(IntegerListConverter::class) expected: List<Int>,
    ) {
        val input = StringAddCalculatorInput(input = text)

        val parsedInput = input.parse()

        assertEquals(expected.count(), parsedInput.count())
        expected.forEachIndexed { i, e -> assertEquals(e, parsedInput[i]) }
    }

    @ParameterizedTest
    @CsvSource(value = ["1:2:3?1,2,3"], delimiter = '?')
    fun `콜론을 구분자로 활용하여 문자열을 파싱`(
        text: String,
        @ConvertWith(IntegerListConverter::class) expected: List<Int>,
    ) {
        val input = StringAddCalculatorInput(input = text)

        val parsedInput = input.parse()

        assertEquals(expected.count(), parsedInput.count())
        expected.forEachIndexed { i, e -> assertEquals(e, parsedInput[i]) }
    }

    @ParameterizedTest
    @MethodSource("generateCustomDelimiterInput")
    fun `커스텀 구분자를 포함하는 문자열을 파싱`(
        text: String,
        expected: List<Int>,
    ) {
        val input = StringAddCalculatorInput(
            input = text
        )

        val parsedInput = input.parse()

        assertEquals(expected.count(), parsedInput.count())
        expected.forEachIndexed { i, e -> assertEquals(e, parsedInput[i]) }
    }

    companion object {
        @JvmStatic
        private fun generateCustomDelimiterInput(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    "//!\n1!2!3", listOf(1, 2, 3)
                ),
                Arguments.of(
                    "//!\n1:2!3,4", listOf(1, 2, 3, 4)
                ),
            )
        }
    }
}
