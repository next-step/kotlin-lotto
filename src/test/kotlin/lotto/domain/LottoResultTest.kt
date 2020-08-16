package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoResultTest {
    @Test
    fun `collectAllPrizes() 당첨 합계 금액`() {
        val result = LottoResult(TICKETS_FIRST_TO_NONE, WINNING_TICKET)

        assertThat(result.collectAllPrizes()).isEqualTo(2031555000)
    }

    @Test
    fun `totalProfitRate() 총 로또 비용대비 수익률 계산`() {
        val result = LottoResult(TICKETS_FIRST_TO_NONE, WINNING_TICKET)

        assertThat(result.totalProfitRate()).isEqualTo(203155.5f)
    }

    @ParameterizedTest
    @MethodSource("provideTicketsMatches")
    fun `get() 결과를 Rank의 갯수로 반환`(ticket: Ticket, expectedRank: Rank) {
        assertThat(
            LottoResult(
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
        private val TICKETS_FIRST_TO_NONE = listOf(
            Ticket(setOf(1, 2, 3, 4, 5, 6)),
            Ticket(setOf(1, 2, 3, 4, 5, 7)),
            Ticket(setOf(1, 2, 3, 4, 5, 16)),
            Ticket(setOf(1, 2, 3, 4, 15, 16)),
            Ticket(setOf(1, 2, 3, 14, 15, 16)),
            Ticket(setOf(1, 2, 13, 14, 15, 16)),
            Ticket(setOf(1, 12, 13, 14, 15, 16)),
            Ticket(setOf(11, 12, 13, 14, 15, 16)),
            Ticket(setOf(11, 12, 13, 14, 15, 16)),
            Ticket(setOf(11, 12, 13, 14, 15, 16))
        )

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
