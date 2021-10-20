package calculator.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperandsTest {
    @ParameterizedTest
    @CsvSource(
        "'-1', '0'",
        "'2', '!'",
        "'3', 'aaa'",
        "'테스트', '7'",
    )
    fun `0보다 작거나 숫자가 아닌 피연산자를 입력하면 IllegalArgumentException이 발생한다`(operand1: String, operand2: String) {
        Assertions.assertThatThrownBy {
            Operands.from(listOf(operand1, operand2))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(
        ",",
        ", ''",
        "'', ''",
        ",'0'",
        "'', '0'",
        "'0', '0'",
    )
    fun `덧셈 결과가 0인 테스트`(operand1: String?, operand2: String?) {
        val operands = Operands.from(listOf(operand1, operand2) as List<String>)

        assertThat(operands.getSum()).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(
        "'0','1'",
        "'12', '25'",
        "'345', '467'"
    )
    fun `0이상의 숫자를 입력하면 정상적으로 피연산자가 생성된다`(operand1: String, operand2: String) {
        val operands = Operands.from(listOf(operand1, operand2))

        assertThat(operands).isNotNull
        assertThat(operands.size()).isEqualTo(2)
        assertThat(operands[0]).isEqualTo(Operand.from(operand1))
        assertThat(operands[1]).isEqualTo(Operand.from(operand2))
    }
}
