package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.RuntimeException

class EquationParserTest {

    @ValueSource(strings = [" ", ""])
    @ParameterizedTest
    fun `공백인 경우 0을 반환함`(input: String) {
        assertThat(EquationParser.parse(input))
            .flatExtracting(Operand::operand)
            .containsExactly(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "99", "0"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환`(input: String) {
        assertThat(EquationParser.parse(input))
            .flatExtracting(Operand::operand)
            .containsExactly(input.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "a", "ㅎㅎ"])
    fun `숫자가 아닌 입력값이 있는 경우 예외`(input: String) {
        assertThrows<RuntimeException> { EquationParser.parse(input) }
            .also { assertThat(it.message).isEqualTo("피연산자는 숫자만 입력하실 수 있습니다.") }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-99", "-2100000000"])
    fun `음수인 경우 예외`(input: String) {
        assertThrows<RuntimeException> { EquationParser.parse(input) }
            .also { assertThat(it.message).isEqualTo("피연산자는 0이상의 수만 입력하실 수 있습니다.") }
    }
}