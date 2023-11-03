package stringAddCalculatorTest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvSource
import stringAddCalculator.StringAddCalculatorInput

class StringAddCalculatorInputTest {
    @ParameterizedTest
    @CsvSource(value = ["1,2,3:1,2,3"], delimiter = ':')
    fun `","를 구분자로 활용하여 문자열을 파싱`(
        text: String,
        @ConvertWith(IntegerListConverter::class) expected: List<Int>
    ) {
        val input = StringAddCalculatorInput(input = text)

        val parsedInput = input.parse()

        assertEquals(expected.count(), parsedInput.count())
        expected.forEachIndexed { i, e -> assertEquals(e, parsedInput[i]) }
    }
}
