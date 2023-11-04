import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class AddCalculatorTest {

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 IlIllegalArgumentException 처리를 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun emptyOrNull(text: String?) {
        assertThrows(IllegalArgumentException::class.java) {
            AddCalculator.add(text)
        }
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun oneNumber(text: String) {
        assertThat(AddCalculator.add(text)).isSameAs(Integer.parseInt(text))
    }

    @DisplayName(value = "','을 구분자로 한 숫자 두 개를 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun twoNumbers(text: String) {
        assertThat(AddCalculator.add(text)).isSameAs(3)
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun colons(text: String) {
        assertThat(AddCalculator.add(text)).isSameAs(6)
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiter(text: String) {
        assertThat(AddCalculator.add(text)).isSameAs(6)
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,-2:3", "//;\n1;2;-3", "-1"])
    fun negative(expression: String) {
        assertThrows(RuntimeException::class.java) {
            AddCalculator.add(expression)
        }
    }
}
