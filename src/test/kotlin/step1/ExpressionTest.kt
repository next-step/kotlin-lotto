package step1

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExpressionTest {

    private lateinit var expression: Expression

    @BeforeEach
    fun setUp() {
        expression = Expression()
    }

    @ValueSource(strings = ["", " "])
    @ParameterizedTest
    fun `빈 문자열이 입력된 경우 0 return`(source: String) {
        assertThat(expression.getTokens(source)).isEqualTo(listOf(0))
    }

    @ValueSource(strings = ["1:2:3", "1,2,3", "1,2:3"])
    @ParameterizedTest
    fun `구분자를 통해 토큰을 출력한다 - 다양한 토큰이 한 문자열에 있는 경우에도 출력 가능하다`(source: String) {
        assertThat(expression.getTokens(source)).isEqualTo(listOf(1, 2, 3))
    }

    @ValueSource(strings = ["-1:2:3"])
    @ParameterizedTest
    fun `음수가 들어오면 예외를 반환한다`(source: String) {
        assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            expression.getTokens(source)
        }
    }

    @ValueSource(strings = ["//;\\n1;2;3"])
    @ParameterizedTest
    fun `문자 사이에 커스텀 구분자를 지정할 수 있다`(source: String) {
        val expression = Expression()
        assertThat(expression.getTokens(source)).isEqualTo(listOf(1, 2, 3))
    }
}
