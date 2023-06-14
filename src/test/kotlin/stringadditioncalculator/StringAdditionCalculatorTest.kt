package stringadditioncalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class StringAdditionCalculatorTest {

    private lateinit var calculator: StringAdditionCalculator

    @BeforeEach
    fun setup() {
        calculator = StringAdditionCalculator()
    }

    @ParameterizedTest
    @MethodSource("getValidExpressions")
    fun `문자열 덧셈 계산기는 구분자를 기준으로 분리된 각 숫자의 합을 반환`(expression: String?, expected: Int) {
        val actual = calculator.calculate(expression)
        actual shouldBe expected
    }

    @ParameterizedTest
    @MethodSource("getInvalidExpressions")
    fun `문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다`(expression: String?) {
        shouldThrow<RuntimeException> {
            calculator.calculate(expression)
        }
    }

    companion object {
        @JvmStatic
        fun getValidExpressions(): List<Arguments> {
            return listOf(
                Arguments.of("", 0),
                Arguments.of(null, 0),
                Arguments.of("1;2;3", 6),
                Arguments.of("1;1,1", 3),
                Arguments.of("//a\\n2a2;2", 6),
                Arguments.of("///\\n1;2;3;4,5,6/7/8/9,10", 55),
            )
        }

        @JvmStatic
        fun getInvalidExpressions(): List<Arguments> {
            return listOf(
                Arguments.of("-1"),
                Arguments.of("asdasd"),
                Arguments.of("a,b;c"),
                Arguments.of("//+\\n1+2,-3"),
            )
        }
    }
}
