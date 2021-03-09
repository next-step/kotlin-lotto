import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CalculatorTest {
    private val calculator = Calculator()

    @ParameterizedTest
    @MethodSource("defaultDelimiterDataset")
    fun `기본 구분자를 이용한 수식의 결과값이 정상적으로 더해진다`(formula: String, result: Int) {
        val num = calculator.calculate(formula)
        assertThat(num, `is`(result))
    }

    @ParameterizedTest
    @MethodSource("customDelimiterDataset")
    fun `커스텀 구분자를 이용한 수식의 결과값이 정상적으로 더해진다`(formula: String, result: Int) {
        val num = calculator.calculate(formula)
        assertThat(num, `is`(result))
    }

    @Test
    fun `음수가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            calculator.calculate("-1,1,1")
        }
    }

    @Test
    fun `구분자 이외의 문자가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            calculator.calculate("1&1,1")
        }
    }

    companion object {
        @JvmStatic
        fun defaultDelimiterDataset(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of("1,2:3", 6),
                    Arguments.of("2:2:3", 7),
                    Arguments.of("1,5,3", 9)
            )
        }

        @JvmStatic
        fun customDelimiterDataset(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of("//;\n1;2;3", 6),
                    Arguments.of("//+\n2+2+3", 7),
                    Arguments.of("//p\n1p5p3", 9)
            )
        }
    }
}
