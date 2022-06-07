package lotto.domain

import lotto.domain.`interface`.LottoFixedNumbers
import lotto.domain.`interface`.LottoRandomNumbers
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningTicketTest {
    @Test
    fun `당첨티켓의 번호는 6 자리다`() {
        val winningTicket = WinningTicket(LottoTicket(LottoRandomNumbers().createNumbers()), 7)
        assertThat(winningTicket.numbers.size).isEqualTo(6)
    }

    @Test
    fun `당첨티켓은 보너스 번호를 가질 수 있다`() {
        val winningTicket = WinningTicket(LottoTicket(LottoRandomNumbers().createNumbers()), 7)
        assertThat(winningTicket.bonusNumber).isEqualTo(7)
    }

    @Test
    fun `당첨티켓의 보너스 번호가 로또 번호와 중복될 경우 에러가 발생한다`() {
        val lottoNumbers = LottoFixedNumbers().createNumbers(listOf(1, 2, 3, 4, 5, 6))

        Assertions.assertThatThrownBy {
            WinningTicket(LottoTicket(lottoNumbers), 6)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("보너스 번호가 로또 번호와 중복됩니다.")
    }
}
