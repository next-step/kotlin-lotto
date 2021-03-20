package lotto.ticket

import lotto.result.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class WinningTicketTest {

    @Test
    fun `당첨 번호와 로또를 맞춰 당첨 상금을 지급받는다`() {
        // given
        val winningTicket = WinningTicket.ofTxNumbers(txNumbers = "1,2,3,4,5,6", txBonusBall = "12")
        val lottoTicket = LottoTicket(ManualDrawPolicy("1,2,3,15,11,12"))

        // when
        // then
        assertThat(winningTicket.match(lottoTicket)).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `5개 + 보너스볼까지 일치시 2등 보너스 상금을 지급받는다`() {
        // given
        val winningTicket = WinningTicket.ofTxNumbers(txNumbers = "1,2,3,11,15,6", txBonusBall = "12")
        val lottoTicket = LottoTicket(ManualDrawPolicy("1,2,3,15,11,12"))

        // when
        // then
        assertThat(winningTicket.match(lottoTicket)).isEqualTo(Rank.BONUS_SECOND)
    }

    @Test
    fun `이등보너스볼과 당첨번호는 중복번호를 허용하지 않는다`() {
        assertThrows<IllegalArgumentException> {
            WinningTicket.ofTxNumbers(
                txNumbers = "1,2,3,11,15,6",
                txBonusBall = "15"
            )
        }
    }
}
