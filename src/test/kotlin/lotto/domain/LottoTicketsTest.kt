package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTicketsTest {

    @Test
    fun `일급 컬렉션 끼리 덧셈연산이 제대로 되는지 확인`() {
        // given
        val lottoTickets1 = LottoTickets(
            listOf(
                LottoTicket(1, 2, 3, 4, 5, 6),
                LottoTicket(2, 3, 4, 5, 6, 7)
            )
        )
        val lottoTickets2 = LottoTickets(
            listOf(
                LottoTicket(4, 5, 6, 7, 8, 9)
            )
        )

        // when
        val combinedLottoTickets = lottoTickets1 + lottoTickets2

        // then
        assertThat(combinedLottoTickets.size()).isEqualTo(3)
    }
}
