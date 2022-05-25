package stringaddcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class AddCalculatorTest {
    private lateinit var addCalculator: AddCalculator

    @BeforeEach
    fun setUp() {
        addCalculator = AddCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null을 입력할 경우 0을 반환해한다`(expression: String?) {
        assertThat(addCalculator.calculate(Expression(expression))).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 1", "100, 100", "0, 0", "5, 5"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(expression: String, expect: Int) {
        assertThat(addCalculator.calculate(Expression(expression))).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["'1,2',3", "'1,2,3,4,5',15"])
    fun `숫자를 컴마(,) 구분자로 입력할 경우 숫자들의 합을 반환한다`(expression: String, expect: Int) {
        assertThat(addCalculator.calculate(Expression(expression))).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["'1:2',3", "'1:2:3:4:5',15"])
    fun `숫자를 콜론 구분자로 입력할 경우 숫자들의 합을 반환한다`(expression: String, expect: Int) {
        assertThat(addCalculator.calculate(Expression(expression))).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["'1:2,5',8", "'1:2,3:4,5',15"])
    fun `숫자를 컴마(,)와 콜론 구분자로 입력할 경우 숫자들의 합을 반환한다`(expression: String, expect: Int) {
        assertThat(addCalculator.calculate(Expression(expression))).isEqualTo(expect)
    }

    @DisplayName(value = "//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다")
    @ParameterizedTest
    @CsvSource(value = ["'//;\\n3;2',5", "'1:2,3#4,5//#\\n',15"])
    fun customDelimiterTest(expression: String, expect: Int) {
        assertThat(addCalculator.calculate(Expression(expression))).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1,2,3", "a,10;5"])
    fun `음수나 숫자 이외의 값을 전달할 경우 RuntimeException 예외가 발생한다`(expression: String) {
        assertThatIllegalArgumentException().isThrownBy {
            addCalculator.calculate(Expression(expression))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["//10\\n12,3", "//5\\n1;2;3"])
    fun `커스텀 구분자에 숫자를 전달할 경우 RuntimeException 예외가 발생한다`(expression: String) {
        assertThatIllegalArgumentException().isThrownBy {
            addCalculator.calculate(Expression(expression))
        }
    }

    @ParameterizedTest
    @MethodSource("expressionParseTest")
    fun `Expression parse() 테스트`(expression: String, expect: List<Int>) {
        assertThat(Expression(expression).parse()).isEqualTo(expect)
    }

    companion object {
        @JvmStatic
        private fun expressionParseTest(): List<Arguments> {
            return listOf(
                Arguments.of("1:2,3", listOf(1, 2, 3)),
                Arguments.of("//&\\n1&2:3", listOf(1, 2, 3)),
                Arguments.of("1,2//&\\n&3", listOf(1, 2, 3))
            )
        }
    }
}
