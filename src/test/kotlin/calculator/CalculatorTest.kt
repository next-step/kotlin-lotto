package calculator

import calculator.domain.Calculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `숫자들을 합할때`() {
        val numbers = listOf("1", "2", "3", "4")

        assertThat(calculator.calculate(numbers)).isEqualTo(10)
    }

    @Test
    fun `숫자들중 음수가 포함되어 있을때`() {
        val numbers = listOf("1", "2", "3", "-4")

        assertThrows<RuntimeException>("음수는 계산식에 포함될 수 없습니다.") { calculator.calculate(numbers) }
    }

    @Test
    fun `숫자들중 문자가 포함되어 있을때`() {
        val numbers = listOf("1", "2", "3", "a")

        assertThrows<RuntimeException>("문자는 계산식에 포함될 수 없습니다.") { calculator.calculate(numbers) }
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    fun `숫자들의 리스트가 들어와서 모두 합해줄 때`(numbers: List<String>, result: Int) {
        var sum = 0
        for (number in numbers) {
            sum += number.toInt()
        }

        assertThat(sum).isEqualTo(result)
    }

    companion object {
        @JvmStatic
        private fun provideNumbers(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("1", "2", "3", "4"), 10),
                Arguments.of(listOf("3", "5", "2", "1"), 11),
                Arguments.of(listOf("1", "6", "3", "4"), 14)
            )
        }
    }
}
