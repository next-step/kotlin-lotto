package addingCalculator.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException

internal class ValidatorTest {

    @Test
    fun `빈 값이 들어오는 경우 0을 리턴한다`() {
        // given
        val testNotation = ""

        // when
        val result = Validator().checkNullOrEmpty(testNotation)

        // then
        Assertions.assertThat(result).isEqualTo("0")
    }

    @Test
    fun `null이 들어오는 경우 0을 리턴한다`() {
        // given
        val testNotation = null

        // when
        val result = Validator().checkNullOrEmpty(testNotation)

        // then
        Assertions.assertThat(result).isEqualTo("0")
    }

    @Test
    fun `연산 대상에 음수가 있는 경우 RuntimeError를 던진다`() {
        // given
        val testNotation = "1:2:-3"
        val parsedNotation = ColonParserImpl().parse(testNotation)

        // then
        assertThrows<RuntimeException> {
            Validator().checkValidNumber(parsedNotation)
        }
    }

    @Test
    fun `연산 대상에 특수문자가 있는 경우 RuntimeError를 던진다`() {
        // given
        val testNotation = "1:2:*"
        val parsedNotation = ColonParserImpl().parse(testNotation)

        // then
        assertThrows<RuntimeException> {
            Validator().checkValidNumber(parsedNotation)
        }
    }

    @Test
    fun `연산 대상에 문자가있는 경우 RuntimeError를 던진다`() {
        // given
        val testNotation = "1:2:a"
        val parsedNotation = ColonParserImpl().parse(testNotation)

        // then
        assertThrows<RuntimeException> {
            Validator().checkValidNumber(parsedNotation)
        }
    }
}
