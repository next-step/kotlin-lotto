package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class ExpressionTest {
    @Test
    fun `생성할때 수식을 받는다`() {
        assertThat(Expression("2,3")).isEqualTo(Expression("2,3"))
    }

    @Test
    fun `구문을 빌드한다`() {
        assertAll(
            { assertThat(Expression("1,2").syntax).isEqualTo("1,2") },
            { assertThat(Expression("1:2").syntax).isEqualTo("1,2") },
            { assertThat(Expression("//;\n1;2;3").syntax).isEqualTo("1,2,3") }
        )
    }

    @Test
    fun `구문의 구분자는 항상 동일하다`() {
        assertAll(
            { assertThat(Expression("1,2").delimiter).isEqualTo(",") },
            { assertThat(Expression("1:2").delimiter).isEqualTo(",") },
            { assertThat(Expression("//;\n1;2;3").delimiter).isEqualTo(",") }
        )
    }
}
