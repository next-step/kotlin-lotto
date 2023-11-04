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
}
