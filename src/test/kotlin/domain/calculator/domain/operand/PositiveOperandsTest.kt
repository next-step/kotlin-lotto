package domain.calculator.domain.operand

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("피연산자들(PositiveOperands)")
class PositiveOperandsTest {

    @Test
    fun `비어있지 않은 리스트로 생성할 수 있다`() {
        val operandList = listOf(PositiveOperand(1), PositiveOperand(2))
        val positiveOperands = PositiveOperands.of(operandList)

        assertAll(
            { assertThat(positiveOperands).isNotNull },
            { assertThat(positiveOperands).isExactlyInstanceOf(PositiveOperands::class.java) },
        )
    }
}
