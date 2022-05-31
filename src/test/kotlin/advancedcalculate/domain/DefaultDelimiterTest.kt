package advancedcalculate.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

class DefaultDelimiterTest {
    @Test
    fun `문자열이 주어지면 구분자를 구분해 구분자를 생성한다`() {
        val input = "1,2,3"

        val delimiter = Delimiter.from(input)
        Assertions.assertThat(delimiter).isInstanceOf(DefaultDelimiter::class.java)
    }

    @Test
    fun `문자열이 주어지면 구분자를 구분해 Operand의 펙토리 역할을 한다`() {
        val input = "1,2,3"

        val delimiter = Delimiter.from(input)
        val operands = delimiter.extractOperands()

        assertAll(
            "delimiter",
            { Assertions.assertThat(operands.size).isEqualTo(3) },
            { Assertions.assertThat(operands[0].value).isEqualTo(1.0) },
            { Assertions.assertThat(operands[1].value).isEqualTo(2.0) },
            { Assertions.assertThat(operands[2].value).isEqualTo(3.0) }
        )
    }
}
