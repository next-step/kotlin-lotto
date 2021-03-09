package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun init() {
        calculator = Calculator()
    }

    @Test
    fun `숫자들을 합할때`() {
        val numbers = listOf("1", "2", "3", "4")

        assertThat(calculator.calculate(numbers)).isEqualTo(10)
    }

    @Test
    fun `숫자들중 음수가 포함되어 있을때`() {
        val numbers = listOf("1", "2", "3", "-4")

        assertThrows<RuntimeException> { calculator.calculate(numbers) }
    }

    @Test
    fun `숫자들중 문자가 포함되어 있을때`() {
        val numbers = listOf("1", "2", "3", "a")

        assertThrows<RuntimeException> { calculator.calculate(numbers) }
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
