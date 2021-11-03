package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {

    @Test
    fun `당첨넘버와 보너스넘버가 중복될때 생성 실패`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5, 6)
            WinningNumber(
                numbers = WinningNumbers(numbers), BonusNumber(6)
            )
        }
    }

    @Test
    fun `당첨번호 사이즈가 5일때 생성 실패`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5)
            WinningNumber(
                numbers = WinningNumbers(numbers), BonusNumber(8)
            )
        }
    }

    @Test
    fun `당첨번호 사이즈가 7일때 생성 실패`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
            WinningNumber(
                numbers = WinningNumbers(numbers), BonusNumber(8)
            )
        }
    }
}
