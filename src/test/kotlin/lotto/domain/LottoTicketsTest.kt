package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTicketsTest {
    @Test
    fun `구입한 로또 티켓에 대해 일치하는 당첨번호 개수 목록을 구할 수 있다`() {
        val lottoTickets = LottoTickets(
            3, listOf(
                LottoTicket(listOf(1, 2, 3, 24, 25, 26)),
                LottoTicket(listOf(1, 2, 3, 34, 35, 36)),
                LottoTicket(listOf(11, 12, 13, 14, 15, 16))
            )
        )
        val winningNumbers = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        val listMatchCount = lottoTickets.match(winningNumbers)
        assertEquals(listMatchCount[0], 0)
        assertEquals(listMatchCount[1], 3)
        assertEquals(listMatchCount[2], 3)
    }
}
