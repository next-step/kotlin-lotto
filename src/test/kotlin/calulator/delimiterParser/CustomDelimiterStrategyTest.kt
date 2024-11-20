import calulator.delimiterParser.CustomDelimiterStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CustomDelimiterStrategyTest {

    private val strategy = CustomDelimiterStrategy()

    @Test
    fun `유효한 사용자 정의 구분자 형식에 대해 support가 true를 반환한다`() {
        val input = "//;\n1;2;3"
        val result = strategy.support(input)
        assertThat(result).isTrue()
    }

    @Test
    fun `유효한 사용자 정의 구분자 형식이 아닌 경우 support가 false를 반환한다`() {
        val input = "1,2,3"
        val result = strategy.support(input)
        assertThat(result).isFalse()
    }

    @Test
    fun `파싱에 성공하여 정상적인 응답을 반환한다`() {
        val input = "//;\n1;2;3"
        val result = strategy.parse(input)
        assertThat(result).containsExactly(1, 2, 3)
    }
}
