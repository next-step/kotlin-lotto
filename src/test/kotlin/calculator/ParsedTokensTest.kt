package calculator

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class ParsedTokenTest {
    @Test
    fun `파싱된 토큰들의 result는 이들을 합한 값이다`() {
        assertThat(
            ParsedTokens(
                listOf(Token("12"), Token("34"))
            ).result
        ).isEqualTo(46)
    }
}
