package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperandCollectionTest {

    @Test
    fun `stringOperands 의 합을 반환한다`() {
        // given
        val operandCollection = OperandCollection(listOf(Operand("1"), Operand("2")))
        val expectResult = 1 + 2

        // when
        val result = operandCollection.add()

        // then
        assertThat(result).isEqualTo(expectResult)
    }
}
