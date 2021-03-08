package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CalculatorTest {

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
