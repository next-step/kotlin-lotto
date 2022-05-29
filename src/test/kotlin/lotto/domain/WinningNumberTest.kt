package lotto.domain

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningNumberTest {
    @Test
    internal fun `지난주 당첨 번호 숫자 6개를 입력받아 LottoTicket으로 변환한다`() {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        assertDoesNotThrow { WinningNumber().winningNumberToLottoTicket(winningNumber) }
    }

    @Test
    internal fun `잘못된 당첨 번호 숫자를 입력하면 IllegalArgumentException이 발생한다`() {
        val winningNumber = listOf(1, 2, 3, 4, 5, 46)
        assertThrows<IllegalArgumentException> { WinningNumber().winningNumberToLottoTicket(winningNumber) }
    }
}
