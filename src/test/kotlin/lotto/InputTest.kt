package lotto

import lotto.view.InputView
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class InputTest {
    private val inputView = InputView()

    @Test
    fun `로또 구입금액에 빈 문자열 또는 null을 입력한 경우`() {
        assertThrows<IllegalArgumentException> { inputView.invalidateMoney(null) }
        assertThrows<IllegalArgumentException> { inputView.invalidateMoney("") }
    }

    @Test
    fun `로또 구입금액에 숫자가 아닌 값을 입력한 경우`() {
        assertThrows<IllegalArgumentException> { inputView.invalidateMoney("abc") }
    }
}
