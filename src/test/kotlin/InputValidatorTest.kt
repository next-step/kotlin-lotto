import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @ValueSource(strings = ["1", "2", "3"])
    @ParameterizedTest
    fun `숫자 하나만 입력해도 검증에 성공한다`(input: String) {
        try {
            InputValidator.validate(listOf(input))
        } catch (e: RuntimeException) {
            Assertions.fail(e.message)
        }
    }

    @ValueSource(strings = ["1,2,3", "1:2:3", "1,2:3"])
    @ParameterizedTest
    fun `기본 구분자가 있는 입력 값을 검증할 수 있다`(input: String) {
        val tokens = InputParser.parse(input)

        try {
            InputValidator.validate(tokens)
        } catch (e: RuntimeException) {
            Assertions.fail(e.message)
        }
    }

    @ValueSource(strings = ["//@\n1@2@3", "//!\n1!2!3", "//?\n1?2?3"])
    @ParameterizedTest
    fun `커스텀 구분자가 있는 입력 값을 검증할 수 있다`(input: String) {
        val tokens = InputParser.parseByCustomDelimiter(input)

        try {
            InputValidator.validate(tokens)
        } catch (e: RuntimeException) {
            Assertions.fail(e.message)
        }
    }

    @ValueSource(strings = ["abcd", "1,2,a", "a:b:c"])
    @ParameterizedTest
    fun `문자열이 포함되면 RuntimeException이 발생한다`(input: String) {
        val tokens = InputParser.parse(input)

        Assertions.assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            InputValidator.validate(tokens)
        }
    }

    @ValueSource(strings = ["1,2,-3", "-1"])
    @ParameterizedTest
    fun `음수가 포함되면 RuntimeException이 발생한다`(input: String) {
        val tokens = InputParser.parse(input)

        Assertions.assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            InputValidator.validate(tokens)
        }
    }
}
