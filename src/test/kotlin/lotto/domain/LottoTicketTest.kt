package lotto.domain

import lotto.dto.LottoMatchResult
import lotto.enum.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("로또 티켓 검증 테스트")
class LottoTicketTest {

    @Test
    @DisplayName("당첨 번호와 모두 일치할 때 확인")
    fun `당첨 번호와 모두 일치하는 경우`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val matchResult = createMatchResultWithMockedWinningTicket(ticket.getNumbers())
        val rank = matchResult.determineRank(ticket)
        assertEquals(Rank.FIRST, rank, "모든 번호가 일치하면 1등입니다.")
    }

    @Test
    @DisplayName("당첨 번호가 3개 일치할 때 확인")
    fun `당첨 번호와 3개가 일치하는 경우`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 10, 11, 12))
        val matchResult = createMatchResultWithMockedWinningTicket(listOf(1, 2, 3, 7, 8, 9))
        val rank = matchResult.determineRank(ticket)
        assertEquals(Rank.FIFTH, rank, "3개 번호가 일치하면 5등입니다.")
    }

    @Test
    @DisplayName("당첨 번호가 일치하지 않을 때 확인")
    fun `당첨 번호와 일치하지 않는 경우`() {
        val ticket = LottoTicket(listOf(10, 11, 12, 13, 14, 15))
        val matchResult = createMatchResultWithMockedWinningTicket(listOf(1, 2, 3, 4, 5, 6))
        val rank = matchResult.determineRank(ticket)
        assertEquals(Rank.MISS, rank, "일치하는 당첨 번호가 없어야 합니다.")
    }

    @Test
    @DisplayName("보너스 볼이 티켓에 포함되어 있을 때 2등을 확인")
    fun `티켓에 보너스 볼이 포함되어 있고, 5개 번호가 일치하는 경우`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 7))
        val matchResult = createMatchResultWithMockedWinningTicket(listOf(1, 2, 3, 4, 5, 6), 7)
        val rank = matchResult.determineRank(ticket)
        assertEquals(Rank.SECOND, rank, "5개 번호와 보너스 볼이 일치하면 2등입니다.")
    }

    @Test
    @DisplayName("보너스 볼이 티켓에 포함되어 있지 않아 3등을 확인")
    fun `티켓에 보너스 볼이 포함되어 있지 않고, 5개 번호가 일치하는 경우`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val matchResult = createMatchResultWithMockedWinningTicket(listOf(1, 2, 3, 4, 5, 8), 7)
        val rank = matchResult.determineRank(ticket)
        assertEquals(Rank.THIRD, rank, "5개 번호가 일치하고 보너스 볼이 일치하지 않으면 3등입니다.")
    }

    @Test
    @DisplayName("5개의 당첨 번호와 보너스 볼 일치 시 2등 당첨을 확인")
    fun `5개의 당첨 번호와 보너스 볼 일치 시 2등 당첨 확인`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 8))
        val matchResult = createMatchResultWithMockedWinningTicket(listOf(1, 2, 3, 4, 5, 7), 8)
        val rank = matchResult.determineRank(ticket)
        assertEquals(Rank.SECOND, rank, "5개의 당첨 번호와 보너스 볼 일치 시 2등에 해당해야 합니다.")
    }

    private fun createMatchResultWithMockedWinningTicket(winningNumbers: List<Int>, bonusBall: Int = 0): LottoMatchResult {
        val winningTicket = LottoTicket(winningNumbers)
        return LottoMatchResult(listOf(), winningTicket, bonusBall)
    }
}
