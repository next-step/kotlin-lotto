package lotto.domain

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningLottoTest {
    @Test
    internal fun `지난주 당첨 번호 숫자 6개와 보너스 숫자를 입력받아 LottoTicket으로 변환한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        assertDoesNotThrow { WinningLotto(winningNumbers, bonusNumber) }
    }

    @Test
    internal fun `로또 번호가 될 수 없는 당첨 번호 숫자를 입력하면 IllegalArgumentException이 발생한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 46)
        val bonusNumber = 7
        assertThrows<IllegalArgumentException> { WinningLotto(winningNumbers, bonusNumber) }
    }

    @Test
    internal fun `로또 번호가 될 수 없는 보너스 번호 숫자를 입력하면 IllegalArgumentException이 발생한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 0
        assertThrows<IllegalArgumentException> { WinningLotto(winningNumbers, bonusNumber) }
    }

    @Test
    internal fun `당첨 번호와 중복된 보너스 번호를 입력하면 IllegalArgumentException이 발생한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 6
        assertThrows<IllegalArgumentException> { WinningLotto(winningNumbers, bonusNumber) }
    }
}
