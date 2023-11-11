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
    fun `정상적인 포맷의 input을 받았을 때, 당첨 번호 리스트를 생성한다면, 콤마를 기준으로 구분하여 리스트를 반환한다`() {
        // given : 당첨 번호를 입력 받는다.
        val inputWinningNumber = "1,2,3,4,5,8"

        // when : 당첨 번호 리스트를 생성한다.
        val actual = LottoInputView.createWinningNumber(inputWinningNumber)

        // then : 콤마를 기준으로 구분하여 리스트를 반환한다
        assertThat(actual).isEqualTo(listOf(1, 2, 3, 4, 5, 8))
    }

    @Test
    fun `숫자가 아닌 값이 포함된 input을 받았을 때, 당첨 번호 리스트를 생성한다면, 에러를 던진다`() {
        // given : 숫자가 아닌 값이 포함된 input을 받는다.
        val inputWinningNumber = "1,2a,3,4,5,8"

        // when : 당첨 번호 리스트를 생성한다.
        val actual = runCatching { LottoInputView.createWinningNumber(inputWinningNumber) }.exceptionOrNull()

        // then : 에러를 던진다.
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }

    @Test
    fun `번호가 6개를 초과하는 input을 받았을 때, 당첨 번호 리스트를 생성한다면, 에러를 던진다`() {
        // given : 6개를 초과하는 당첨번호 input을 받는다.
        val inputWinningNumber = "1,2,3,4,5,8,30"

        // when : 당첨 번호 리스트를 생성한다.
        val actual = runCatching { LottoInputView.createWinningNumber(inputWinningNumber) }.exceptionOrNull()

        // then : 에러를 던진다.
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `1~45 범위를 벗어나는 input을 받았을 때, 당첨 번호 리스트를 생성한다면, 에러를 던진다`() {
        // given : 1 ~ 45 범위를 벗어나는 당청번호 input을 받는다.
        val inputWinningNumber = "1,2,3,4,5,50"

        // when : 당첨 번호 리스트를 생성한다.
        val actual = runCatching { LottoInputView.createWinningNumber(inputWinningNumber) }.exceptionOrNull()

        // then : 에러를 던진다.
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `중복되는 값을 가진 input을 받았을 때, 당첨 번호 리스트를 생성한다면, 에러를 던진다`() {
        // given : 종복되는 번호 조합을 가진 당첨번호 input을 받는다.
        val inputWinningNumber = "1,2,3,4,5,3"

        // when : 당첨 번호 리스트를 생성한다.
        val actual = runCatching { LottoInputView.createWinningNumber(inputWinningNumber) }.exceptionOrNull()

        // then : 에러를 던진다.
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
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
