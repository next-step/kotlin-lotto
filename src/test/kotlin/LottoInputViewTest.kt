import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import view.LottoInputView

class LottoInputViewTest {

    @Test
    fun `숫자 포맷이 아닌 문자열을 입력 받았을 때, 검증을 거치면, 에러를 던진다`() {
        // given : 숫자 포멧이 아닌 문자열 입력을 받는다.
        val lottoInputViewTest = LottoInputView()
        val inputData = "1b"

        // when : 입력값에 대한 검증을 진행한다.
        val actual = runCatching { lottoInputViewTest.validateCashInputData(inputData) }.exceptionOrNull()

        // then : 에러를 던진다
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }

    @Test
    fun `정수값이 아닌 문자열을 입력 받았을 때, 검증을 거치면, 에러를 던진다`() {
        // given : 정수값이 아닌 문자열 입력을 받는다.
        val lottoInputViewTest = LottoInputView()
        val inputData = "1.8"

        // when : 입력값에 대한 검증을 진행한다.
        val actual = runCatching { lottoInputViewTest.validateCashInputData(inputData) }.exceptionOrNull()

        // then : 에러를 던진다
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }

    @Test
    fun `1,000원 미만 값을 입력 받았을 때, 검증을 거치면, 에러를 던진다`() {
        // given : 1000원 미만의 값을 입력 받는다.
        val lottoInputViewTest = LottoInputView()
        val inputData = "900"

        // when : 입력값에 대한 검증을 진행한다.
        val actual = runCatching { lottoInputViewTest.validateCashInputData(inputData) }.exceptionOrNull()

        // then : 에러를 던진다
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }

    @Test
    fun `100,000원 초과 값을 입력 받았을 때, 검증을 거치면, 에러를 던진다`() {
        // given : 100,000원을 초과한 값을 입력 받는다.
        val lottoInputViewTest = LottoInputView()
        val inputData = "110000"

        // when : 입력값에 대한 검증을 진행한다.
        val actual = runCatching { lottoInputViewTest.validateCashInputData(inputData) }.exceptionOrNull()

        // then : 에러를 던진다
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }
}
