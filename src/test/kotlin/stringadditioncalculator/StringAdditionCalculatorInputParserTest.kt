package stringadditioncalculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class StringAdditionCalculatorInputParserTest {

    @ParameterizedTest(name = "{0} should {1}")
    @MethodSource("getEmptyOrNullInput")
    fun `문자열 덧셈 계산기 입력 파서는 빈값("") 또는 null 이 들어오면 빈 리스트를 반환한다`(input: String?, expected: List<String>) {
        val parser = StringAdditionCalculatorInputParser()
        val actual = parser.parse(input)

        actual shouldBe expected
    }

    @ParameterizedTest(name = "{0} should {1}")
    @MethodSource("getStringInputIncludeDefaultDelimiters")
    fun `문자열 덧셈 계산기 입력 파서는 쉼표 또는 콜론을 구분자로 가지는 문자열을 분리할 수 있다`(input: String?, expected: List<String>) {
        val parser = StringAdditionCalculatorInputParser()
        val actual = parser.parse(input)

        actual shouldBe expected
    }

    @ParameterizedTest(name = "{0} should {1}")
    @MethodSource("getStringInputIncludeCustomDelimiters")
    fun `문자열 앞부분의 슬래시슬래시와 줄마꿈 사이에 위치하는 문자를 커스텀 구분자로 사용한다`(input: String?, expected: List<String>) {
        val parser = StringAdditionCalculatorInputParser()
        val actual = parser.parse(input)

        actual shouldBe expected
    }

    companion object {
        @JvmStatic
        fun getEmptyOrNullInput(): List<Arguments> = listOf(
            Arguments.of("", emptyList<String>()),
            Arguments.of(null, emptyList<String>()),
        )

        @JvmStatic
        fun getStringInputIncludeDefaultDelimiters(): List<Arguments> = listOf(
            Arguments.of("1", listOf("1")),
            Arguments.of("1,2", listOf("1", "2")),
            Arguments.of("1,2;3", listOf("1", "2", "3")),
            Arguments.of("1;2", listOf("1", "2")),
            Arguments.of("1;2,3", listOf("1", "2", "3")),
        )

        @JvmStatic
        fun getStringInputIncludeCustomDelimiters(): List<Arguments> = listOf(
            Arguments.of("//a\\n1a2", listOf("1", "2")),
            Arguments.of("//;\\n1;2", listOf("1", "2")),
            Arguments.of("//.\\n1.2;3,4", listOf("1", "2", "3", "4")),
        )
    }
}
