package string_calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    private lateinit var stringAddCalculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        stringAddCalculator = StringAddCalculator()
    }

    @DisplayName(value = "아무것도 입력되지 않을 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = ["  ", "\t", "\n"])
    fun emptyInput(input: String) {
        val result = stringAddCalculator.calculate(input)
        assertThat(result).isZero()
    }

    @DisplayName(value = "기본적으로 ',', ';'를 문자열을 구분해서 숫자를 입력하면 입력된 숫자의 합을 반환한다.")
    @ParameterizedTest(name = "{index} => input=''{0}'', expected=''{1}''")
    @CsvSource(
        "1,2,3=6",
        "1,2:3=6",
        "1:2:3=6",
        "1:2,3=6",
        ",1:2,3=6",
        "1:2,3,=6",
        "1=1",
        delimiterString = "="
    )
    fun calculateInput(input: String, expected: Int) {
        val result = stringAddCalculator.calculate(input)
        assertThat(result).isEqualTo(expected)
    }

    @DisplayName(value = "입력된 문자열이 '//'로 시작할 경우 '\n'이 나올 때까지의 문자열을 커스텀 구분자로 기본 구분자에 포함해서 계산한다.")
    @ParameterizedTest(name = "{index} => input=''{0}'', expected=''{1}''")
    @MethodSource("provideCustomInputs")
    fun customInput(input: String, expected: Int) {
        val result = stringAddCalculator.calculate(input)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `커스텀 문자열은 한 개이상일 경우 RuntimeException이 발생한다`() {

    }

    @Test
    fun `입력된 문자열이 슬래시 슬래시로 시작할 경우 new line이 나오지 않는다면 RuntimeException이 발생한다`() {

    }

    @Test
    fun `커스텀 문자열이 없다면 기본 구분자로 문자열을 parsing 한다`() {

    }

    @Test
    fun `구분자가 연속해서 나온다면 RuntimeException이 발생한다`() {

    }

    @Test
    fun `구분자 사이에는 숫자 String이 있어야 한다`() {

    }

    companion object {
        @JvmStatic
        fun provideCustomInputs() = arrayOf(
            arrayOf("//-\n1-2-3", 6),
            arrayOf("//m\n1m2m3", 6),
            arrayOf("//#\n1#2#3", 6),
            arrayOf("//-\n1-2--3", 6),
            arrayOf("//-\n1", 1)
        )
    }
}