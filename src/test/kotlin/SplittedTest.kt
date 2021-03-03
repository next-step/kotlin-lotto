import ExpressionTest.Expression
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SplittedTest {
    @Test
    fun `표현식으로부터 글자 리스트 표현한다`() {
        assertThat(Splitted(Expression("1,2"))).containsExactlyInAnyOrder("1", "2")
    }

    data class Splitted(private val letters: List<String>) : List<String> by letters {
        constructor(letters: Expression) : this(listOf("1", "2"))
    }
}
