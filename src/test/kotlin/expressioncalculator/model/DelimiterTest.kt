package expressioncalculator.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DelimiterTest {
    @Test
    fun `Delimiter는 문자열을 구분하는 데 필요한 구분자를 보관한다`() {
        val regex = "[,:]".toRegex()
        val delimiter = Delimiter(regex)

        assertThat(delimiter.value).isEqualTo(regex)
    }

    @Test
    fun `정규식 대신 문자열을 생성자에 넘겨서 보관할 수 있다`() {
        val pattern = ";"
        val delimiter = Delimiter(pattern)

        assertThat(delimiter.value.pattern).isEqualTo(pattern)
    }
}
