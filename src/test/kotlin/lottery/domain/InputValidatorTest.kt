package lottery.domain

import io.kotest.matchers.shouldBe
import lottery.validator.InputValidator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InputValidatorTest {

    @Test
    fun `유효한 지난 주 당첨 번호를 입력하면 리스트를 반환한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val result = InputValidator.validateWinningNumbers("1,2,3,4,5,6")

        result.shouldBe(lottoNumbers)
    }

    @Test
    fun `지난 주 당첨 번호가 하나라도 숫자가 아니면 오류를 반환한다`() {
        Assertions.assertThatThrownBy {
            InputValidator.validateWinningNumbers("a,2,3,4,5,6")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `지난 주 당첨 번호가 하나라도 음수 번호를 가지면 오류를 반환한다`() {
        Assertions.assertThatThrownBy {
            InputValidator.validateWinningNumbers("-1,2,3,4,5,6")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
