
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class StringAddCalculatorTest {

    @MethodSource("addStringTestParameter")
    @ParameterizedTest
    fun `정상 케이스의 문자열을 입력 받았을 때, 계산을 요청한다면, 문자열의 수를 합한 값이 배출된다`(inputData: String, expected: Int) {
        // given : 정상 케이스의 문자열을 입력 받았을 때

        // when : 계산을 요청한다.
        val actual = StringAddCalculator.calculate(inputData)

        // then : 문자열의 수를 합한 값이 배출된다.
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `공백을 입력했을 때, 계산을 요청하면, 0을 배출한다`() {
        // given : null 값을 입력 받는다.
        val inputData = ""

        // when : 분리된 문자열의 합을 구한다.
        val actual = StringAddCalculator.calculate(inputData)

        // then : 0을 반환한다.
        assertThat(actual).isEqualTo(0)
    }

    @Test
    fun `숫자 하나를 문자열로 입력했을 때, 문자열의 합을 구한다면, 해당 숫자를 배출한다 `() {
        // given : 숫자 하나를 문자열로 입력한다. "5"
        val inputData = "5"

        // when : 문자열의 합을 구한다.
        val actual = StringAddCalculator.calculate(inputData)

        // then : 입력한 숫자 문자열을 배출한다. 5
        assertThat(actual).isEqualTo(5)
    }

    @MethodSource("customDelimiterTestParameter")
    @ParameterizedTest
    fun `커스텀 문자열 사용`(inputData: String, expected: Int) {
        // given : //과 \n에 구분자로 사용할 값을 숫자 문자열과 같이 받는다.

        // when : 문자열을 나눈다.
        val actual = StringAddCalculator.calculate(inputData)

        // then : 커스텀 문자열을 기준으로 구분되어 list를 생성한다
        assertThat(actual).isEqualTo(expected)
    }

    @MethodSource("validationTestParameter")
    @ParameterizedTest
    fun `,숫자 이외의 값 혹은 음수가 포함되어 초기화 된다면, RuntimeException를 던진다`(inputData: String, expected: Exception) {
        // given :

        // when : 숫자 이외의 값 혹은 음수로 초기화를 시도한다.
        val actual = runCatching { StringAddCalculator.calculate(inputData) }.exceptionOrNull()

        // then : 오류가 발생한다.
        assertThat(actual).isInstanceOf(expected::class.java)
    }

    companion object {
        private const val ERR_MSG_INCLUDE_NOT_NUMBER_FORMAT = "입력값에 숫자 포맷이 아닌 것이 있습니다."
        private const val ERR_MSG_INCLUDE_NEGATIVE_NUMBER = "입력값에 음수가 있습니다."

        @JvmStatic
        fun addStringTestParameter() = listOf(
            arrayOf("2,3,4", 9),
            arrayOf("2,5:8", 15),
            arrayOf("1:2:7", 10)
        )

        @JvmStatic
        fun customDelimiterTestParameter() = listOf(
            arrayOf("//d\n2d3d4", 9),
            arrayOf("//@\n2@5@8", 15),
            arrayOf("//_\n1_2_7", 10)
        )

        @JvmStatic
        fun validationTestParameter() = listOf(
            arrayOf("//d\n2dhd4", RuntimeException(ERR_MSG_INCLUDE_NOT_NUMBER_FORMAT)),
            arrayOf("1,2,3ㅣ3", RuntimeException(ERR_MSG_INCLUDE_NOT_NUMBER_FORMAT)),
            arrayOf("//@\n2@-5@8", RuntimeException(ERR_MSG_INCLUDE_NEGATIVE_NUMBER)),
            arrayOf("8:9,0:8:-2", RuntimeException(ERR_MSG_INCLUDE_NEGATIVE_NUMBER))
        )
    }
}
