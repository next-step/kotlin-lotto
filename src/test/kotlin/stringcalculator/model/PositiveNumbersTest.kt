package stringcalculator.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import stringcalculator.service.StringParser

class PositiveNumbersTest {
    @Test
    internal fun `숫자 문자열 리스트를 받는다`() {
        val strings = listOf("1", "2", "3", "4")
        val expected = strings.map { PositiveNumber.of(it) }
        val positiveNumbers = PositiveNumbers.of(strings)
        assertThat(positiveNumbers.value).isEqualTo(expected)
    }

    @Test
    internal fun `숫자가 아닌 값이 포함된 리스트`() {
        val strings = listOf("1", "&", "3", "4")
        assertThrows<IllegalArgumentException> { PositiveNumbers.of(strings) }
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["1;2,3,4", """/;\n1;2;3,4""", """//;\n//e\n1e2e3e4""", """//;\n//e\n//a\n1a2a3a4"""]
    )
    internal fun `잘못 변환된 리스트로 인스턴스 생성`(input: String) {
        val strings = StringParser.convertToList(input)
        assertThrows<IllegalArgumentException> { PositiveNumbers.of(strings) }
    }
}
