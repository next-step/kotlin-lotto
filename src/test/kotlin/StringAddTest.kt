import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringAddTest {
    @ValueSource(strings = ["-1", "a"])
    @ParameterizedTest
    fun `음수 값, 숫자가아닌 인풋이 들어오면 런타임 익셉션 던진다`(input: String) {
        val inputValidator = InputValidator()

        assertThrows<RuntimeException> {
            inputValidator.checkNatualAndZero(input)
        }
    }

    @Test
    fun `쉼표 또는 콜론을 기준으로 구분한다`() {
        val input = "1,3:5"
        val inputParser = InputParser()
        val parsed = inputParser.parse(input, ",|:")

        assertThat(parsed[0]).isEqualTo("1")
        assertThat(parsed[1]).isEqualTo("3")
        assertThat(parsed[2]).isEqualTo("5")
    }

    @Test
    fun `커스텀 구분자를 설정할 수 있다`() {
        val input = "//;\n1;2;3"
        val result = "//(.)\n(.*)".toRegex().find(input)

        result?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)

            assertThat(tokens[0]).isEqualTo("1")
            assertThat(tokens[1]).isEqualTo("2")
            assertThat(tokens[2]).isEqualTo("3")
        }
    }

    @Test
    fun `리스트의 합을 반환한다`() {
        val numbers = listOf(1, 2, 3)
        val addCalculator = AddCalculator()

        val answer = addCalculator.sum(numbers)
        val expect = 6
        assertThat(answer).isEqualTo(expect)
    }

    @Test
    fun `쉽표, 콜론으로 구분하여 수의 합을 반환한다`() {
        val input = "1:2,3:4"

        val inputValidator = InputValidator()
        val inputParser = InputParser()
        val addCalculator = AddCalculator()

        val tokens = inputParser.parse(input)

        tokens.forEach {
            inputValidator.checkNatualAndZero(it)
        }

        val numbers = tokens.map { it.toInt() }
        val answer = addCalculator.sum(numbers)

        val expect = 10
        assertThat(answer).isEqualTo(expect)
    }
}
