package lotto.domain

import lotto.fixture.lotto
import lotto.fixture.lottoTickets
import lotto.fixture.winningLotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class LottoTicketsTest {
    @Test
    fun `LottoTicket N장에 대한 당첨 결과(당첨 등수, 당첨 갯수)를 알 수 있다`() {
        // given
        val lottoTickets = lottoTickets(
            lotto(1, 2, 3, 4, 5, 26),
            lotto(1, 2, 3, 4, 5, 36),
            lotto(1, 2, 3, 4, 35, 36),
            lotto(1, 2, 3, 34, 35, 36),
            lotto(1, 2, 33, 34, 35, 36),
            lotto(1, 32, 33, 34, 35, 36),
            lotto(31, 32, 33, 34, 35, 36),
        )
        val winningLotto = winningLotto(1, 2, 3, 4, 5, 6)
        val bonusNumber = BonusNumber(26)
        // when
        val matchResult: Map<Rank, Count> = lottoTickets.match(winningLotto, bonusNumber)
        // then
        assertNull(matchResult[Rank.FIRST])
        assertEquals(1, matchResult[Rank.SECOND]!!.count)
        assertEquals(1, matchResult[Rank.THIRD]!!.count)
        assertEquals(1, matchResult[Rank.FOURTH]!!.count)
        assertEquals(1, matchResult[Rank.FIFTH]!!.count)
        assertEquals(3, matchResult[Rank.MISS]!!.count)
    }
}
