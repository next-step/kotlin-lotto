package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberParserTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "42", "999", "1000", "100000"])
    fun `숫자로만 이루어진 문자열은 하나의 숫자로 파싱한다`(input: String) {
        val parser = NumberParser(emptyList())

        val result = parser.parseNumbers(input)

        assertThat(result).containsExactly(input.toInt())
    }
}
