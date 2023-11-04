package calculator

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class PositiveNumberListTest {
    @Test
    fun `파싱된 토큰들의 result는 이들을 합한 값이다`() {
        assertThat(
            PositiveNumberList(
                listOf(PositiveNumber("12"), PositiveNumber("34"))
            ).sum
        ).isEqualTo(46)
    }
}
