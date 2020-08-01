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

    @Test
    fun `spliter의 초기 값은 콜론과 콤마`() {
        assertThat(
            Parser().spliter
        ).contains(":", ",").hasSize(2)
    }

    @Test
    fun `checkIfCustomPrefix() 프리픽스로 커스텀 구분자 있으면 spliter에 추가`() {
        val parser = Parser()
        assertThat(parser.spliter).contains(":", ",").hasSize(2)

        parser.checkIfCustomPrefix("//;\n1:1:1")

        assertThat(parser.spliter).contains(":", ",", ";").hasSize(3)
    }
}
