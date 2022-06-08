package lotto.domain

import lotto.domain.`interface`.LottoFixedNumbers
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningTicketTest {
    @Test
    fun `당첨티켓의 번호는 6 자리다`() {
        val lottoTicket = LottoTicket(LottoFixedNumbers(listOf(1, 2, 3, 4, 5, 6)).createNumbers())
        val winningTicket = WinningTicket(lottoTicket, 7)
        assertThat(winningTicket.lottoTicket.lottoNumbers.size).isEqualTo(6)
    }

    @Test
    fun `당첨티켓은 보너스 번호를 가질 수 있다`() {
        val lottoTicket = LottoTicket(LottoFixedNumbers(listOf(1, 2, 3, 4, 5, 6)).createNumbers())
        val winningTicket = WinningTicket(lottoTicket, 7)
        assertThat(winningTicket.bonusNumber).isEqualTo(7)
    }

    @Test
    fun `당첨티켓은 보너스 티켓인지 알 수 있다`() {
        val lottoTicket = LottoTicket(LottoFixedNumbers(listOf(1, 2, 3, 4, 5, 6)).createNumbers())
        val winningTicket = WinningTicket(
            LottoTicket(LottoFixedNumbers(listOf(3, 4, 5, 6, 7, 8)).createNumbers()),
            1
        )
        assertThat(winningTicket.isBonusTicket(lottoTicket, 4)).isEqualTo(true)
    }

    @Test
    fun `당첨티켓의 보너스 번호가 로또 번호와 중복될 경우 에러가 발생한다`() {
        val lottoNumbers = LottoFixedNumbers(listOf(1, 2, 3, 4, 5, 6)).createNumbers()

        Assertions.assertThatThrownBy {
            WinningTicket(LottoTicket(lottoNumbers), 6)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("보너스 번호가 로또 번호와 중복됩니다.")
    }
}
