package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoAnalyticsTest {
    @ParameterizedTest
    @MethodSource("provideTicketsMatches")
    fun `matchTickets() 티켓의 결과를 Rank 목록으로 반환`(ticket: Ticket, expectedRank: Rank) {
        assertThat(
            LottoAnalytics.matchTickets(
                listOf(
                    ticket
                ),
                WINNING_TICKET
            )
        ).satisfies {
            assertThat(it[expectedRank]).isEqualTo(1)
        }
    }

    companion object {
        private val WINNING_TICKET = WinningTicket(
            Ticket(setOf(1, 2, 3, 4, 5, 6)),
            BonusNumber(7)
        )

        @JvmStatic
        private fun provideTicketsMatches(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Ticket(setOf(1, 2, 3, 4, 5, 6)), Rank.FIRST_PRIZE),
                Arguments.of(Ticket(setOf(1, 2, 3, 4, 5, 7)), Rank.SECOND_PRIZE),
                Arguments.of(Ticket(setOf(1, 2, 3, 4, 5, 16)), Rank.THIRD_PRIZE),
                Arguments.of(Ticket(setOf(1, 2, 3, 4, 15, 16)), Rank.FOURTH_PRIZE),
                Arguments.of(Ticket(setOf(1, 2, 3, 14, 15, 16)), Rank.FIFTH_PRIZE),
                Arguments.of(Ticket(setOf(11, 12, 13, 14, 15, 16)), Rank.NONE)
            )
        }
    }
}
