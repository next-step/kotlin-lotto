package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
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
}
