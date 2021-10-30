package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ExpressionTest {
    @Test
    fun `구분자를 컴마 이외에 콜론을 사용할 수 있다`() {

        Assertions.assertThat(Expression.make("1,2:3").value).isEqualTo(listOf("1", "2", "3"))
    }
}
