package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ParserTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,2;3", "1;2;3", "1,2,3"])
    // 쉼표 ( , ) 와 컬럼 ( ; )
    fun `기본 구분자를 기준으로 문자열을 숫자로 변환한다`(expression: String) {
        assertThat(Parser().parse(expression)).isEqualTo(listOf("1", "2", "3"))
    }

    @ParameterizedTest
    @ValueSource(strings = ["//a\n1a2a3", "//ab\n1ab2ab3"])
    // 문자열 앞부분에서 "//" 와 "\n" 값이 오면 그 사이에 있는 값을 커스텀 구분자로 한다.
    fun `커스텀 구분자로 지정할 수 있다`(expression: String) {
        assertThat(Parser().parse(expression)).isEqualTo(listOf("1", "2", "3"))
    }
}
