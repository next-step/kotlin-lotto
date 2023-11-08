import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class StringAddCalculatorTest {

    @Test
    fun `문자열을 입력받았을 때, 쉼표 또는 콜론을 구분자로 나눈다면, 숫자 리스트를 배출한다`() {
        // given : "1,3,5"를 입력받았을 때
        val stringAddCalculator = StringAddCalculator("1,3:6")

        // when :  쉼표 또는 클론을 구분자로 하여 나눈다
        val actual = stringAddCalculator.splitInput()

        // then :
        assertThat(actual).isEqualTo(listOf("1", "3", "6"))
    }

    @MethodSource("addStringTestParameter")
    @ParameterizedTest
    fun `분리된 문자열을 받았을 때, 문자열의 합을 구한다면, 합한 수를 배출한다`(inputData: String, expected: Int) {
        // given : 분리된 문자열을 받는다.
        val stringAddCalculator = StringAddCalculator(inputData)
        val splitString = stringAddCalculator.splitInput()

        // when : 문자열의 합을 구한다.
        val actual = stringAddCalculator.addString(splitString)

        // then : 합한 수를 배출한다.
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun addStringTestParameter() = listOf(
            arrayOf("2,3,4", 9),
            arrayOf("2,5:8", 15),
            arrayOf("1:2:7", 10)
        )
    }
}
