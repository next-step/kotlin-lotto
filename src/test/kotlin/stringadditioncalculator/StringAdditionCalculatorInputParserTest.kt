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

    companion object {
        @JvmStatic
        fun getEmptyOrNullInput(): List<Arguments> {
            return listOf(
                Arguments.of("", emptyList<String>()),
                Arguments.of(null, emptyList<String>()),
            )
        }
    }
}
