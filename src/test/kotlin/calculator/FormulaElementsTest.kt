package calculator

import calculator.Operand.Companion.toOperand
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FormulaElementsTest {
    @Test
    fun `콤마가 포함된 문자열 식을 변환할 수 있다`() {
        // given
        val formula = "1,2"

        // when
        val result = FormulaElements(formula)

        // then
        assertThat(result.startValue).isEqualTo(1.toOperand())
        assertThat(result.nextFormulaElement()).isEqualTo(2.withOperation(Operation.PLUS))
        assertThat(result.nextFormulaElement()).isNull()
    }

    @Test
    fun `콜론이 포함된 문자열 식을 변환할 수 있다`() {
        // given
        val formula = "1:2"

        // when
        val result = FormulaElements(formula)

        // then
        assertThat(result.startValue).isEqualTo(1.toOperand())
        assertThat(result.nextFormulaElement()).isEqualTo(2.withOperation(Operation.PLUS))
        assertThat(result.nextFormulaElement()).isNull()
    }

    @Test
    fun `숫자가 포함되지 않은 문자열이 전달된다면 startValue 값은 0을 반환하고 nextFormulaElement 값은 null이다`() {
        // given
        val noFormulaString = ""

        // when
        val result = FormulaElements(noFormulaString)

        // then
        assertThat(result.startValue).isEqualTo(0.toOperand())
        assertThat(result.nextFormulaElement()).isNull()
    }

    @DisplayName("\\\\ 와 \\n 사이에 위치하는 문자를 커스텀 구분자로 지정할 수 있다 커스텀 구분자는 PLUS 로 치환된다")
    @Test
    fun customDelimiter() {
        // given
        val customFormula = "//;\n1;2;3"

        // when
        val result = FormulaElements(customFormula)

        // then
        assertThat(result.startValue).isEqualTo(1.toOperand())
        assertThat(result.nextFormulaElement()).isEqualTo(2.withOperation(Operation.PLUS))
        assertThat(result.nextFormulaElement()).isEqualTo(3.withOperation(Operation.PLUS))
        assertThat(result.nextFormulaElement()).isNull()
    }


    private fun Int.withOperation(operation: Operation): FormulaElement = FormulaElement(toOperand(), operation)
}
