package lotto.domain

import lotto.fixture.bonusNumber
import lotto.fixture.lotto
import lotto.fixture.lottoTickets
import lotto.fixture.winningLotto
import org.assertj.core.api.Assertions.assertThat
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
        val bonusNumber = bonusNumber(26)
        // when
        val matchResult = lottoTickets.match(winningLotto, bonusNumber).matchResult
        // then
        assertNull(matchResult[Rank.FIRST])
        assertEquals(1, matchResult[Rank.SECOND]!!.count)
        assertEquals(1, matchResult[Rank.THIRD]!!.count)
        assertEquals(1, matchResult[Rank.FOURTH]!!.count)
        assertEquals(1, matchResult[Rank.FIFTH]!!.count)
        assertEquals(3, matchResult[Rank.MISS]!!.count)
    }

    @Test
    fun `2개의 LottoTickets를 하나의 LottoTickets으로 합쳐준다`() {
        // given
        val autoLottos = lottoTickets(
            lotto(1, 2, 3, 4, 5, 6),
        )
        val manualLottos = lottoTickets(
            lotto(11, 12, 13, 14, 15, 16),
        )

        // when
        val lottoTickets = autoLottos.merge(manualLottos)

        // then
        assertThat(lottoTickets.lottoTickets.size).isEqualTo(2)
    }

    @Test
    fun `LottoTickets 합쳐진 결과에는 중복 상관없이 전체 Lotto 수가 유지 되어야 한다 `() {
        // given
        val autoLottos = lottoTickets(
            lotto(1, 2, 3, 4, 5, 6),
        )
        val manualLottos = lottoTickets(
            lotto(1, 2, 3, 4, 5, 6),
        )

        // when
        val lottoTickets = autoLottos.merge(manualLottos)

        // then
        assertThat(lottoTickets.lottoTickets.size).isEqualTo(2)
    }

    @Test
    fun `모두 emptyList여도 LottoTickets로 합쳐준다`() {
        // given
        val autoLottos = lottoTickets()
        val manualLottos = lottoTickets(
            lotto(1, 2, 3, 4, 5, 6),
        )

        // when
        val lottoTickets = autoLottos.merge(manualLottos)

        // then
        assertThat(lottoTickets.lottoTickets.size).isEqualTo(1)
    }

    @Test
    fun `emptyList가 있어도 LottoTickets로 합쳐준다`() {
        // given
        val autoLottos = lottoTickets()
        val manualLottos = lottoTickets()

        // when
        val lottoTickets = autoLottos.merge(manualLottos)

        // then
        assertThat(lottoTickets.lottoTickets.size).isEqualTo(0)
    }
}
