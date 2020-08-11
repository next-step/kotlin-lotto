package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoAnalyticsTest {
    @Test
    fun `matchTickets() 티켓의 결과를 Rank 목록으로 반환`() {
        assertThat(
            LottoAnalytics().matchTickets(
                listOf(
                    Ticket(1, 2, 3, 4, 5, 6),
                    Ticket(1, 2, 3, 4, 5, 16),
                    Ticket(1, 2, 3, 4, 15, 16),
                    Ticket(1, 2, 3, 14, 15, 16),
                    Ticket(11, 12, 13, 14, 15, 16)
                ),
                WINNER_TICKET
            )
        ).satisfies {
            assertThat(it[Rank.FIRST_PRIZE]).isEqualTo(1)
            assertThat(it[Rank.SECOND_PRIZE]).isEqualTo(1)
            assertThat(it[Rank.THIRD_PRIZE]).isEqualTo(1)
            assertThat(it[Rank.FOURTH_PRIZE]).isEqualTo(1)
            assertThat(it[Rank.NONE]).isEqualTo(1)
        }
    }

    companion object {
        private val WINNER_TICKET = Ticket(1, 2, 3, 4, 5, 6)
    }
}
