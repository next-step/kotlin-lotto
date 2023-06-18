package calculator

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @ValueSource(strings = ["1", "2", "3"])
    @ParameterizedTest
    fun `숫자 하나만 입력해도 검증에 성공한다`(input: String) {
        shouldNotThrow<RuntimeException> {
            InputValidator.validate(listOf(input))
        }
    }

    @ValueSource(strings = ["1,2,3", "1:2:3", "1,2:3"])
    @ParameterizedTest
    fun `기본 구분자가 있는 입력 값을 검증할 수 있다`(input: String) {
        val tokens = InputParser.parse(input)

        shouldNotThrow<RuntimeException> {
            InputValidator.validate(tokens)
        }
    }

    @ValueSource(strings = ["//@\n1@2@3", "//!\n1!2!3", "//?\n1?2?3"])
    @ParameterizedTest
    fun `커스텀 구분자가 있는 입력 값을 검증할 수 있다`(input: String) {
        val tokens = InputParser.parse(input)

        shouldNotThrow<RuntimeException> {
            InputValidator.validate(tokens)
        }
    }

    @ValueSource(strings = ["abcd", "1,2,a", "a:b:c"])
    @ParameterizedTest
    fun `문자열이 포함되면 RuntimeException이 발생한다`(input: String) {
        val tokens = InputParser.parse(input)

        shouldThrow<RuntimeException> {
            InputValidator.validate(tokens)
        }
    }

    @ValueSource(strings = ["1,2,-3", "-1"])
    @ParameterizedTest
    fun `음수가 포함되면 RuntimeException이 발생한다`(input: String) {
        val tokens = InputParser.parse(input)

        shouldThrow<RuntimeException> {
            InputValidator.validate(tokens)
        }
    }
}
