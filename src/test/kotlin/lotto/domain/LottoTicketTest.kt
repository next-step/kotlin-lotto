package lotto.domain

import lotto.dto.LottoMatchResult
import lotto.enum.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("로또 티켓 검증 테스트")
class LottoTicketTest {

    @Test
    @DisplayName("당첨 번호와 모두 일치할 때 확인")
    fun `당첨 번호와 모두 일치하는 경우`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        assertEquals(6, ticket.getMatchingNumbersCount(winningNumbers), "모든 번호가 일치해야 합니다.")
    }

    @Test
    @DisplayName("당첨 번호가 3개 일치할 때 확인")
    fun `당첨 번호와 3개가 일치하는 경우`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 10, 11, 12))
        val winningNumbers = setOf(1, 2, 3, 7, 8, 9)
        assertEquals(3, ticket.getMatchingNumbersCount(winningNumbers), "3개의 당첨 번호가 일치해야 합니다.")
    }

    @Test
    @DisplayName("당첨 번호가 일치하지 않을 때 확인")
    fun `당첨 번호와 일치하지 않는 경우`() {
        val ticket = LottoTicket(listOf(10, 11, 12, 13, 14, 15))
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        assertEquals(0, ticket.getMatchingNumbersCount(winningNumbers), "일치하는 당첨 번호가 없어야 합니다.")
    }

    @Test
    @DisplayName("보너스 볼이 티켓에 포함되어 있을 때 확인")
    fun `티켓에 보너스 볼이 포함되어 있는 경우`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 7))
        val bonusBall = 7
        assertTrue(ticket.containsBonusBall(bonusBall), "보너스 볼이 티켓에 포함되어 있으면 true여야 합니다.")
    }

    @Test
    @DisplayName("보너스 볼이 티켓에 포함되어 있지 않을 때 확인")
    fun `티켓에 보너스 볼이 포함되어 있지 않은 경우`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val bonusBall = 7
        assertFalse(ticket.containsBonusBall(bonusBall), "보너스 볼이 티켓에 포함되어 있지 않으면 false여야 합니다.")
    }

    @Test
    @DisplayName("티켓 번호가 정확한지 확인")
    fun `티켓 번호가 정확한지 확인`() {
        val expectedNumbers = listOf(1, 2, 3, 4, 5, 6)
        val ticket = LottoTicket(expectedNumbers)
        assertEquals(expectedNumbers, ticket.getNumbers(), "로또 티켓의 번호가 정확해야 합니다.")
    }

    @Test
    @DisplayName("5개의 당첨 번호와 보너스 볼 일치 시 2등 당첨을 확인")
    fun `5개의 당첨 번호와 보너스 볼 일치 시 2등 당첨 확인`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 8))
        val winningNumbers = setOf(1, 2, 3, 4, 5, 7)
        val bonusBall = 8
        val rank = LottoMatchResult(listOf(ticket), LottoTicket(winningNumbers.toList()), bonusBall).determineRank(ticket)
        assertEquals(Rank.SECOND, rank, "5개의 당첨 번호와 보너스 볼 일치 시 2등에 해당해야 합니다.")
    }
}
