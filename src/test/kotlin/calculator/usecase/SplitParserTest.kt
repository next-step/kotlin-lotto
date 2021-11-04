package calculator.usecase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SplitParserTest {

    private val parser = SplitParser()

    @ValueSource(strings = ["1,2,3", "1,2:3", "1:2:3"])
    @ParameterizedTest
    fun `1,2,3이 basic separator 로 이루어졌을 때 결과 listOf(1,2,3)`(input: String) {
        val expected = listOf(1, 2, 3)
        val actual = parser.parse(input)

        assertEquals(expected, actual)
    }

    @ValueSource(strings = ["//;\\n1;2;3", "//$\\n1$2$3", "//%\\n1%2%3"])
    @ParameterizedTest
    fun `1,2,3이 custom separator 로 이루어졌을 때 결과 listOf(1,2,3)`(input: String) {
        val expected = listOf(1,2,3)
        val actual = parser.parse(input)

        assertEquals(expected, actual)
    }

    @ValueSource(strings = ["1$2,3", "1@2:3", "1q2:3"])
    @ParameterizedTest
    fun `숫자, basic separator 가 아닐경우 exception`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }

        assertEquals("숫자를 제외한 문자가 올 수 없습니다.", exception.message)
    }

    @ValueSource(strings = ["1,-2,3", "1,2:-3", "-1,2:3"])
    @ParameterizedTest
    fun `음수가 올경우 exception`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }

        assertEquals("입력값은 음수가 올 수 없습니다.", exception.message)
    }
}
