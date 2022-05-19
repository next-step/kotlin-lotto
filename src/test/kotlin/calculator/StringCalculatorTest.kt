package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class StringCalculatorTest {

    @ParameterizedTest
    @MethodSource("listAndIntProvider")
    fun `계산기는 입력받은 숫자 문자열을 더한 결과를 반환한다`(numberStrings: List<String>, expectResult: Int) {
        val calculator = StringCalculator()
        val sum = calculator.sum(numberStrings)

        assertThat(sum).isEqualTo(expectResult)
    }

    @Test
    fun `음수를 받는 경우 RunTimeException을 반환한다`() {
        val calculator = StringCalculator()

        assertThrows<RuntimeException> { calculator.sum(listOf("-1", "100")) }
    }

    companion object {
        @JvmStatic
        fun listAndIntProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("1", "2"), 3),
                Arguments.of(listOf("1", "10"), 11),
                Arguments.of(listOf("1", "2", "3"), 6),
            )
        }
    }
}
