package domain.calculator.domain.operand

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun `비어있는 리스트로 생성 시도를 할 경우 예외를 발생한다`() {
        assertThrows<RuntimeException> { PositiveOperands.of(listOf()) }
    }

    @Test
    fun `합산 결과를 반환한다`() {
        val operandList = listOf(PositiveOperand(1), PositiveOperand(2))
        val positiveOperands = PositiveOperands.of(operandList)

        assertThat(positiveOperands.sum()).isEqualTo(3)
    }
}
