package lotto

import lotto.domain.WinningNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {

    @Test
    fun `당첨번호가 중복된 경우 IllegalArgumentException 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 2, 2, 1, 1))
        }
    }

    @Test
    fun `당첨번호가 6개가 아닌 경우 IllegalArgumentException 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4))
        }
    }
}
