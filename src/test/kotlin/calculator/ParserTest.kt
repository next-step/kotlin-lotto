package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ParserTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,2;3", "1;2;3", "1,2,3"])
    // 쉼표 ( , ) 와 컬럼 ( ; )
    fun `기본 구분자를 기준으로 문자열을 숫자로 변환한다`(expression: String) {
        assertThat(Parser().parse(expression)).isEqualTo(listOf(1, 2, 3))
    }
}
