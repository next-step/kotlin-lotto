package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    @DisplayName("당첨 번호와 일치하는 번호의 수를 올바르게 계산하는지 테스트")
    fun testGetMatchingNumbersCount() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        assertEquals(6, ticket.getMatchingNumbersCount(winningNumbers))
    }

    @Test
    @DisplayName("다양한 당첨 번호 세트에 대해 올바른 일치 개수를 반환하는지 테스트")
    fun testGetMatchingNumbersCount2() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers1 = setOf(1, 2, 3, 7, 8, 9)
        val winningNumbers2 = setOf(4, 5, 6, 10, 11, 12)
        assertEquals(3, ticket.getMatchingNumbersCount(winningNumbers1), "3개의 번호가 일치해야 합니다.")
        assertEquals(3, ticket.getMatchingNumbersCount(winningNumbers2), "3개의 번호가 일치해야 합니다.")
    }

    @Test
    @DisplayName("올바르게 티켓의 번호를 반환하는지 테스트")
    fun testGetNumbersCorrectNumbers() {
        val expectedNumbers = listOf(1, 2, 3, 4, 5, 6)
        val ticket = LottoTicket(expectedNumbers)
        assertEquals(expectedNumbers, ticket.getNumbers(), "로또 티켓의 번호가 정확해야 합니다.")
    }
}
