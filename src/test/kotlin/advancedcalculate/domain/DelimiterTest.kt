package advancedcalculate.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class DelimiterTest {

    @Test
    fun `문자열이 주어지면 구분자를 구분해 구분자를 생성한다`() {
        val input = "1,2,3"

        val delimiter = Delimiter.from(input)
        assertThat(delimiter).isInstanceOf(DefaultDelimiter::class.java)
    }

    @Test
    fun `문자열이 주어지면 구분자를 구분해 Operand의 펙토리 역할을 한다`() {
        val input = "1,2,3"

        val delimiter = Delimiter.from(input)
        val operands = delimiter.extractOperands(input)

        assertAll("delimiter",
            { assertThat(operands.size).isEqualTo(3) },
            { assertThat(operands[0].value).isEqualTo(1.0) },
            { assertThat(operands[1].value).isEqualTo(2.0) },
            { assertThat(operands[2].value).isEqualTo(3.0) }
        )
    }


    @Test
    fun `디폴트 구분자가 아니면 커스텀 구분자를 찾는다 구분자를 생성한다`() {
        val input = "//;\\n1;2;3"

        val delimiter = Delimiter.from(input)
        val customDelimiter = delimiter as CustomDelimiter

        assertThat(customDelimiter.customDelimiter).isEqualTo(";")
    }

    @ParameterizedTest
    @ValueSource(strings = ["/;\\n1;2;3", "asa", "///al.", "1=0,1+3"])
    fun `주어진 형식이 아니면 exception 발생`(input: String) {
        val delimiter = Delimiter.from(input)

        assertThrows<IllegalArgumentException> {
            delimiter.extractOperands(input)
        }
    }
}
