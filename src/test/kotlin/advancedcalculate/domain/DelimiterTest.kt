package advancedcalculate.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class DelimiterTest {

    @Test
    fun `문자열이 주어지면 구분자를 구분해 구분자를 생성한다`() {
        val input = "1,2,3"

        val delimiter = Delimiter(input)
        assertThat(delimiter.value).isEqual(",")
    }

    @Test
    fun `문자열이 주어지면 구분자를 구분해 Operand의 펙토리 역할을 한다`() {
        val input = "1,2,3"

        val delimiter = Delimiter(input)
        val operands = delimiter.extractOperands(input)

        assertAll("delimiter", {
            { assertThat(operands.size()).isEqualTo(3) },
            { assertThat(operands.size().get(0))).isEqualTo(1) },
            { assertThat(operands.size().get(1))).isEqualTo(2) },
            { assertThat(operands.size().get(2))).isEqualTo(3) }
        })
    }


    @Test
    fun `디폴트 구분자가 아니면 커스텀 구분자를 찾는다 구분자를 생성한다`() {
        val input = "//;\n1;2;3"

        val delimiter = Delimiter(input)
        assertThat(delimiter.value).isEqual(";")
    }

    @ParameterizedTest
    @ValueSource(strings = ["/;\n1;2;3", "asa", "///al."])
    fun `주어진 형식이 아니면 excpetion을 발생한다`(input: String) {
        val delimiter = Delimiter(input)

        assertThat(delimiter.value).isEqual(";")

    }
}
