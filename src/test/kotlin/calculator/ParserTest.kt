package calculator

import calculator.Parser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.NumberFormatException

class ParserTest {
    @Test
    internal fun `기본 구분자 사용 테스트`() {
        val inputString = "1,2:3"
        val input = Parser().parse(inputString);
        assertEquals(input.size, 3)
    }

    @Test
    internal fun `커스텀 구분자 사용 테스트`() {
        val inputString = "//;\n1;2;3"
        val input = Parser().parse(inputString);
        assertEquals(input.size, 3)
    }

    @Test
    internal fun `기본도 커스텀도 아닌 구분자 사용 테스트`() {
        val inputString = "1;2;3"

        assertThrows<NumberFormatException> {
            Parser().parse(inputString)
        }
    }
}