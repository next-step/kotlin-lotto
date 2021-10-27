package domain.calculator.domain.operand

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("정수_피연산자(PositiveOperand)")
class PositiveOperandTest {

    @ParameterizedTest(name = "연산식: {0}")
    @ValueSource(strings = ["0", "1", "100", Integer.MAX_VALUE.toString()])
    fun `0 이상의 정수값을 이용해 객체를 생성할 수 있다`(operandString: String) {
        val positiveOperand = PositiveOperand(operandString)

        assertAll(
            { assertThat(positiveOperand).isNotNull },
            { assertThat(positiveOperand).isExactlyInstanceOf(PositiveOperand::class.java) }
        )
    }

    @ParameterizedTest(name = "연산식: {0}")
    @ValueSource(strings = ["-1", "-100", Integer.MIN_VALUE.toString()])
    fun `음수값은 객체를 생성할 수 없다`(operandString: String) {
        assertThrows<RuntimeException> { PositiveOperand(operandString) }
    }

    @ParameterizedTest(name = "연산식: {0}")
    @ValueSource(strings = ["a", "일", "마이너스일"])
    fun `숫자로 변환될 수 없는 문자열은 객체를 생성할 수 없다`(operandString: String) {
        assertThrows<RuntimeException> { PositiveOperand(operandString) }
    }

    @ParameterizedTest(name = "연산식: {0}")
    @ValueSource(strings = ["0", "1", "100", Integer.MAX_VALUE.toString()])
    fun `정수값을 반환한다`(operandString: String) {
        val positiveOperand = PositiveOperand(operandString)

        assertThat(positiveOperand.operand).isEqualTo(operandString.toInt())
    }
}
