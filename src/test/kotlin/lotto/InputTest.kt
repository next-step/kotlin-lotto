package lotto

import lotto.view.InputView
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class InputTest {
    private val inputView = InputView()

    @Test
    fun `로또 구입금액에 빈 문자열 또는 null을 입력한 경우`() {
        assertThrows<IllegalArgumentException> { inputView.validateMoney(null) }
        assertThrows<IllegalArgumentException> { inputView.validateMoney("") }
    }

    @Test
    fun `로또 구입금액에 숫자가 아닌 값을 입력한 경우`() {
        assertThrows<IllegalArgumentException> { inputView.validateMoney("abc") }
    }

    @Test
    fun `입력한 당첨 번호가 null 또는 빈 문자열인 경우`() {
        assertThrows<IllegalArgumentException> { inputView.parseToWinningNums(null) }
        assertThrows<IllegalArgumentException> { inputView.parseToWinningNums("") }
    }

    @Test
    fun `입력한 당첨 번호에 쉼표나 숫자가 아닌 값이 포함되어 있는 경우`() {
        assertThrows<IllegalArgumentException> { inputView.parseToWinningNums("a,b,c,d,e,f") }
        assertThrows<IllegalArgumentException> { inputView.parseToWinningNums("!@#") }
    }

    @Test
    fun `입력한 당첨 번호가 총 6개가 아닌 경우`() {
        assertThrows<IllegalArgumentException> { inputView.parseToWinningNums("1,2,3,4") }
    }

    @Test
    fun `입력한 당첨 번호에 중복된 숫자가 있는 경우`() {
        assertThrows<IllegalArgumentException> { inputView.parseToWinningNums("1,1,2,3,4,5") }
    }

    @Test
    fun `입력한 당첨 번호가 1 ~ 45 사이의 숫자가 아닌 경우`() {
        assertThrows<IllegalArgumentException> { inputView.parseToWinningNums("1,2,3,4,5,50") }
    }

    @Test
    fun `당첨 번호를 바르게 입력한 경우`() {
        assertDoesNotThrow { inputView.parseToWinningNums("1,2,3,4,5,6") }
    }
}
