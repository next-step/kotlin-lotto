package view

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    @Test
    @DisplayName("구매금액에 금액에 숫자외에 문자를 입력하면 IllegalArgumentException 이 발생한다")
    fun `inputNotNumberThrowExceptionCallBuyLotto`() {
        val inputView = InputView()
        assertThrows<IllegalArgumentException> {
            inputView.inputMoneyForBuyLotto { "a" }
        }
    }

    @Test
    @DisplayName("당첨번호에 숫자, 공백, 쉼표 이외에 문자를 입력하면 IllegalArgumentException 이 발생한다")
    fun `inputNotValidRegexThrowExceptionCallPrizeNumber`() {
        val inputView = InputView()
        assertThrows<IllegalArgumentException> {
            inputView.inputLastWeekPrize { "1, a, 3, 4" }
        }
    }
}
