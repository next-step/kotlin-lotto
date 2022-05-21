package expressioncalculator.delimiter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DelimiterTest {
    @Test
    fun `Delimiter는 문자열을 구분하는 데 필요한 구분자를 보관한다`() {
        val regex = ",|:".toRegex()
        val delimiter = Delimiter(regex)

        assertThat(delimiter.value).isEqualTo(regex)
    }
}
