import calculator.StringCalculator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatRuntimeException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    @ParameterizedTest
    @DisplayName(value = "쉼표, 콜론을 구분자로 분리한다.")
    @CsvSource(value = ["'1,2',3", "'1:3',4"])
    fun stringSplitTest(
        inputString: String,
        expacted: Int,
    ) {
        assertThat(StringCalculator.calculate(inputString)).isEqualTo(expacted)
    }

    @ParameterizedTest
    @DisplayName(value = "커스텀 구분자가 있으면 그 구분자로 분리한다.")
    @CsvSource(value = ["'//;\n1;2',3", "'//_\n1_3',4"])
    fun customSplitTest(
        inputString: String,
        expacted: Int,
    ) {
        assertThat(StringCalculator.calculate(inputString)).isEqualTo(expacted)
    }

    @ParameterizedTest
    @DisplayName(value = "음수 및 숫자 아닌값은 에러처리한다.")
    @CsvSource(value = ["'-1:2',3", "'//_\n1@3',4"])
    fun SplitfailTest(
        inputString: String,
        expacted: Int,
    ) {
        assertThatRuntimeException().isThrownBy {
            StringCalculator.calculate(inputString)
        }
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun oneNumber(text: String) {
        assertThat(StringCalculator.calculate(text)).isSameAs(Integer.parseInt(text));
    }


    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun emptyOrNull(text: String?) {
        assertThat(StringCalculator.calculate(text)).isZero();
    }
}
