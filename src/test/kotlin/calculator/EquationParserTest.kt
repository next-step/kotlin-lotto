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
}