package lotto

import lotto.domain.WinningLottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTicketTest {
    @Test
    fun `당첨 번호와 보너스 번호를 입력받아 당첨 티켓을 생성한다`() {
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val winningLottoTicketTest = WinningLottoTicket.of(winningNumbers, bonusNumber)

        assertThat(winningLottoTicketTest.winningNumbers.size).isEqualTo(6)
        assertThat(winningLottoTicketTest.bonusNumber).isEqualTo(7)
    }

    @Test
    fun `당첨 번호가 6개가 아니라면 예외를 발생시킨다`() {
        val winningNumbers = setOf(1, 2, 3, 4, 5)
        val bonusNumber = 7

        assertThrows<IllegalArgumentException>(message = "로또 번호는 6개여야 합니다.") {
            WinningLottoTicket.of(winningNumbers, bonusNumber)
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외를 발생시킨다`() {
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 6

        assertThrows<IllegalArgumentException>(message = "보너스 번호는 당첨 번호와 중복되면 안됩니다.") {
            WinningLottoTicket.of(winningNumbers, bonusNumber)
        }
    }
}
