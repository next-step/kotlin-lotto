import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import view.LottoInputView

class LottoInputViewTest {

    @MethodSource("validateCashInputDataTest")
    @ParameterizedTest
    fun `잘못된 입력값을 받았을 때, 검증을 거치면, 에러를 던진다`(inputData: String, expected: Exception) {
        // given : 100,000원을 초과한 값을 입력 받는다.

        // when : 입력값에 대한 검증을 진행한다.
        val actual = runCatching { LottoInputView.validateCashInputData(inputData) }.exceptionOrNull()

        // then : 에러를 던진다
        assertThat(actual).isInstanceOf(expected::class.java)
    }

    @Test
    fun `당첨 번호에 대한 입력 값 받았을 때, splitWinningNumber()을 요청하면, 콤마를 기준으로 구분하여 리스트를 반환한다`() {
        // given : 당첨 번호를 입력 받는다.
        val inputWinningNumber = "1,2,3,4,5,8"

        // when : splitWinningNumber()을 요청한다.
        val actual = LottoInputView.splitWinningNumber(inputWinningNumber)

        // then : 콤마를 기준으로 구분하여 리스트를 반환한다
        assertThat(actual).isEqualTo(listOf("1","2","3","4","5","8"))
    }

    companion object {
        private const val ERR_MSG_NUMBER_FORMAT_EXCEPTION = "입력값에 대한 포멧이 숫자 아닙니다."
        private const val ERR_MSG_INT_FORMAT_EXCEPTION = "입력값에 대한 포멧이 정수가 아닙니다."
        private const val ERR_MSG_MIN_VALUE_EXCEPTION = "최소값 1,000원 이상의 값을 입력해 주세요"
        private const val ERR_MSG_MAX_VALUE_EXCEPTION = "최대값 100,000원 이하의 값을 입력해 주세요"

        @JvmStatic
        fun validateCashInputDataTest() = listOf(
            arrayOf("1b", IllegalArgumentException(ERR_MSG_NUMBER_FORMAT_EXCEPTION)),
            arrayOf("1000.34", IllegalArgumentException(ERR_MSG_INT_FORMAT_EXCEPTION)),
            arrayOf("900", IllegalArgumentException(ERR_MSG_MIN_VALUE_EXCEPTION)),
            arrayOf("110000", IllegalArgumentException(ERR_MSG_MAX_VALUE_EXCEPTION))
        )
    }
}
