package stringcalculatortest

import org.assertj.core.api.Assertions.assertThat
<<<<<<< HEAD

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName

=======
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
>>>>>>> 4ac6c8dafa5439807629472fb598c89148432157
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import stringcalculator.StringAddCalculator

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
<<<<<<< HEAD
        calculator = StringAddCalculator()
=======
        calculator = StringAddCalculator();
>>>>>>> 4ac6c8dafa5439807629472fb598c89148432157
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
<<<<<<< HEAD
    fun emptyOrNull(text: String?) {
        assertThat(calculator.add(text)).isZero()
=======
    fun emptyOrNull(text: String) {
        assertThat(calculator.add(text)).isZero();
>>>>>>> 4ac6c8dafa5439807629472fb598c89148432157
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun oneNumber(text: String) {
<<<<<<< HEAD
        assertThat(calculator.add(text)).isSameAs(Integer.parseInt(text))
=======
        assertThat(calculator.add(text)).isSameAs(Integer.parseInt(text));
>>>>>>> 4ac6c8dafa5439807629472fb598c89148432157
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun twoNumbers(text: String) {
<<<<<<< HEAD
        assertThat(calculator.add(text)).isSameAs(3)
=======
        assertThat(calculator.add(text)).isSameAs(3);
>>>>>>> 4ac6c8dafa5439807629472fb598c89148432157
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun colons(text: String) {
<<<<<<< HEAD
        assertThat(calculator.add(text)).isSameAs(6)
=======
        assertThat(calculator.add(text)).isSameAs(6);
>>>>>>> 4ac6c8dafa5439807629472fb598c89148432157
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiter(text: String) {
<<<<<<< HEAD
        assertThat(calculator.add(text)).isSameAs(6)
    }
/*
    // 음수 테스트는 결국 실현 못했습니다.
    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    fun negative() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy(() -> calculator.add("-1"))
    }


 */
=======
        assertThat(calculator.add(text)).isSameAs(6);
    }
    /* 음수 테스트는 결국 실현 못했습니다.
    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    @ValueSource(strings = ["//;\n1;2;3"])
    fun negative() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy(() -> calculator.add("-1"));
    }

     */
>>>>>>> 4ac6c8dafa5439807629472fb598c89148432157
}
