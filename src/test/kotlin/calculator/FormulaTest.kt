package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FormulaTest {
    @Test
    fun `첫번째 기본 구분자로 덧셈을 한다`() {
        val formula = Formula("1:2")
        assertThat(formula.calculate()).isEqualTo(3)
    }

    @Test
    fun `두번째 구분자로 덧셈을 한다`() {
        val formula = Formula("1,2")
        assertThat(formula.calculate()).isEqualTo(3)
    }

    @Test
    fun `커스텀 구분자로 덧셈을 한다`() {
        val formula = Formula("//;\n1;2")
        assertThat(formula.calculate()).isEqualTo(3)
    }

    @Test
    fun `공백을 계신기에 입력 시 0을 반환한다`() {
        val formula = Formula("")
        assertThat(formula.calculate()).isEqualTo(0)
    }

    @Test
    fun `null을 계신기에 입력 시 0을 반환한다`() {
        val formula = Formula(null)
        assertThat(formula.calculate()).isEqualTo(0)
    }

}
