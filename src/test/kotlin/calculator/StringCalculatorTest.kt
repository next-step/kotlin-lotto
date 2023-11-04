package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.util.regex.Pattern

class StringCalculator {
    fun inputText(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val matchText = CUSTOM_DELIMITER.matcher(text)
        if (matchText.find()) {
            return matchText.group(2).split(matchText.group(1))
                .map { convertToInt(it) }
                .sumOf { it }
        }

        return text.split(DEFAULT_DELIMITER)
            .map { convertToInt(it) }
            .sumOf { it }
    }

    private fun convertToInt(numberText: String): Int {
        require(numberText.toInt() >= 0) { ERROR_MESSAGE }
        return numberText.toInt()
    }

    companion object {
        private val DEFAULT_DELIMITER: Pattern = Pattern.compile(",|:")
        private val CUSTOM_DELIMITER: Pattern = Pattern.compile("//(.)\n(.*)")
        private const val ERROR_MESSAGE: String = "음수는 입력할 수 없습니다."
    }
}

class StringCalculatorTest {
    private lateinit var calculator: StringCalculator

    @BeforeEach
    fun init() {
        calculator = StringCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(text: String?) {
        calculator.inputText(text) shouldBe 0
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        calculator.inputText(text) shouldBe text.toInt()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2", "2,3", "3,3"])
    fun `숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String) {
        val expected = text.split(",").sumOf { it.toInt() }
        calculator.inputText(text) shouldBe expected
    }

    @ParameterizedTest
    @MethodSource("getSampleData")
    fun `컴마 이외에 콜론을 구분자로 사용할 수 있다`(input: String, expected: Int) {
        calculator.inputText(input) shouldBe expected
    }

    @ParameterizedTest
    @MethodSource("getCustomDelimiterData")
    fun `커스텀 구분자를 지정할 수 있다`(input: String, expected: Int) {
        calculator.inputText(input) shouldBe expected
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1,2", "2,-3", "//;\n-1;2;3"])
    fun `음수를 전달할 경우 예외가 발생한다`(input: String) {
        shouldThrow<IllegalArgumentException> {
            calculator.inputText(input)
        }
    }

    companion object {
        @JvmStatic
        fun getSampleData(): List<Arguments> {
            return listOf(
                Arguments.of(
                    "1,2:3", 6
                ),
                Arguments.of(
                    "2:2:7", 11
                ),
                Arguments.of(
                    "3:1,8", 12
                )
            )
        }

        @JvmStatic
        fun getCustomDelimiterData(): List<Arguments> {
            return listOf(
                Arguments.of(
                    "//;\n1;2;3", 6
                ),
                Arguments.of(
                    "//|\n7|0|4", 11
                ),
            )
        }
    }
}
