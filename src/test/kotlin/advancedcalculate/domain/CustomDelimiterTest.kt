package advancedcalculate.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CustomDelimiterTest {
    @Test
    fun `디폴트 구분자가 아니면 커스텀 구분자를 찾는다 구분자를 생성한다`() {
        val input = "//;\\n1;2;3"

        val delimiter = Delimiter.from(input)
        val customDelimiter = delimiter as CustomDelimiter

        Assertions.assertThat(customDelimiter.customDelimiter).isEqualTo(";")
    }

    @ParameterizedTest
    @ValueSource(strings = ["/;\\n1;2;3", "asa", "///al.", "1=0,1+3"])
    fun `주어진 형식이 아니면 exception 발생`(input: String) {
        val delimiter = Delimiter.from(input)

        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            delimiter.extractOperands()
        }
    }
}
