package textcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ParserTest {
    @Test
    fun `split() 문자열을 구분자로 쪼갠다`() {
        assertThat(
            Parser().split("1:1:2,33")
        ).isEqualTo(
            listOf("1", "1", "2", "33")
        )
    }
}
