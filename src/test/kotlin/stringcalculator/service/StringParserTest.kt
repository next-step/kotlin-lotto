package stringcalculator.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import stringcalculator.model.PositiveNumbers
import stringcalculator.service.StringParser.CUSTOM_DELIMITED_TEXT_REGEX
import stringcalculator.service.StringParser.DEFAULT_DELIMITER

class StringParserTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4", "5:6,7:8", "9:10:11:12"])
    internal fun `쉼표 또는 콜론으로 문자열 분리`(input: String) {
        val numbers = StringParser.convertToList(input)
        val expectedNumbers = PositiveNumbers.of(input.split(DEFAULT_DELIMITER))

        assertThat(numbers).isEqualTo(expectedNumbers)
    }

    @Test
    internal fun `쉼표 또는 콜론이 아닐 경우`() {
        val input = "1;2,3,4"
        assertThrows<IllegalArgumentException> { StringParser.convertToList(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["""//;\n1;2;3;4""", """//\n\n1\n2\n3\n4\n""", """//;\n"""])
    internal fun `커스텀 구분자로 문자열 분리`(input: String) {
        val numbers = StringParser.convertToList(input)
        val (delimiter, delimitedBody) = CUSTOM_DELIMITED_TEXT_REGEX.find(input)!!.destructured
        val expectedNumbers = PositiveNumbers.of(delimitedBody.split(delimiter))

        assertThat(numbers).isEqualTo(expectedNumbers)
    }

    @ParameterizedTest
    @ValueSource(strings = ["""/;\n1;2;3,4""", """//;\n//e\n1e2e3e4""", """//;\n//e\n//a\n1a2a3a4"""])
    internal fun `커스텀 구분자 접두사가 완전하지 않은 경우`(input: String) {
        assertThrows<IllegalArgumentException> { StringParser.convertToList(input) }
    }
}
