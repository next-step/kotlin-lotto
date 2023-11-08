package lotto.domain

import lotto.enum.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("로또 티켓 검증 테스트")
class LottoTicketTest {

    @Test
    @DisplayName("당첨 번호와 일치하는 번호 수 정확히 계산")
    fun `당첨 번호와 일치하는 번호 수 정확히 계산`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        assertEquals(6, ticket.getMatchingNumbersCount(winningNumbers))
    }

    @Test
    @DisplayName("다양한 당첨 번호 세트에서 올바른 일치 개수 반환")
    fun `다양한 당첨 번호 세트에서 올바른 일치 개수 반환`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers1 = setOf(1, 2, 3, 7, 8, 9)
        val winningNumbers2 = setOf(4, 5, 6, 10, 11, 12)
        assertEquals(3, ticket.getMatchingNumbersCount(winningNumbers1), "3개의 번호가 일치해야 합니다.")
        assertEquals(3, ticket.getMatchingNumbersCount(winningNumbers2), "3개의 번호가 일치해야 합니다.")
    }

    @Test
    @DisplayName("티켓 번호 정확히 반환 확인")
    fun `티켓 번호 정확히 반환 확인`() {
        val expectedNumbers = listOf(1, 2, 3, 4, 5, 6)
        val ticket = LottoTicket(expectedNumbers)
        assertEquals(expectedNumbers, ticket.getNumbers(), "로또 티켓의 번호가 정확해야 합니다.")
    }

    @Test
    @DisplayName("보너스 볼 일치 여부 확인")
    fun `보너스 볼이 티켓에 포함되어 있는지 확인`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 7))
        val bonusBall = 7
        assertTrue(ticket.containsBonusBall(bonusBall), "보너스 볼이 티켓에 포함되어 있어야 합니다.")
    }

    @Test
    @DisplayName("2등 당첨 확인")
    fun `5개의 당첨 번호와 보너스 볼 일치 시 2등 당첨을 확인`() {
        // 보너스 볼을 포함하지 않는 5개의 일치하는 번호와 하나의 불일치 번호를 티켓에 넣습니다.
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 8))
        // 5개의 일치하는 번호와 다른 번호 하나를 당첨 번호로 설정합니다.
        val winningNumbers = setOf(1, 2, 3, 4, 5, 7)
        val bonusBall = 8 // 이 번호는 티켓에 있고, 당첨 번호에는 없어야 합니다.
        val matchResult = ticket.getMatchResult(winningNumbers, bonusBall)
        assertEquals(Rank.SECOND, matchResult, "5개의 당첨 번호와 보너스 볼 일치 시 2등에 해당해야 합니다.")
    }
}
