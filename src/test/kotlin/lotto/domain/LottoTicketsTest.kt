package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketsTest {
    private val manualLottoTickets = listOf(LottoTicket.generateByManual(listOf(1, 2, 3, 4, 5, 6)),
        LottoTicket.generateByManual(listOf(7, 8, 9, 10, 11, 12)))

    @Test
    fun `복권 여러장 사기`() {
        assertThat(LottoTickets.make(3, manualLottoTickets).tickets.size).isEqualTo(3)
    }

    @Test
    fun `수동 티켓수가 구입금액보다 높으면 안된다`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LottoTickets.make(1, manualLottoTickets) }
            .withMessage("구입 금액보다 수동 갯수가 더 많습니다.")
    }
}
