package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class LottoTicketsTest {
    @Test
    fun `LottoTickets는 당첨 번호 개수를 카운트 할 수 있다`() {
        val lottoTickets = LottoTickets(
            4,
            listOf(
                LottoTicket(listOf(1, 2, 3, 24, 25, 26)),
                LottoTicket(listOf(1, 2, 3, 34, 35, 36)),
                LottoTicket(listOf(1, 2, 3, 4, 35, 36)),
                LottoTicket(listOf(11, 12, 13, 14, 15, 16))
            )
        )
        val winningNumbers = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        val mapMatchCount = lottoTickets.match(winningNumbers)
        assertEquals(mapMatchCount[WinningInfo.THREE], 2)
        assertEquals(mapMatchCount[WinningInfo.FOUR], 1)
        assertNull(mapMatchCount[WinningInfo.FIVE])
        assertNull(mapMatchCount[WinningInfo.SIX])
    }
}
