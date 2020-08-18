package lotto

import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.LottoTicket
import lotto.model.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameResultsTest {
    private val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })
    private val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })

    @Test
    fun `1등 한명인 경우 테스트`() {
        val lottoTicket = LottoTicket(listOf(lotto1))
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.FIRST)).isEqualTo(1)
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.SECOND)).isEqualTo(0)
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.THIRD)).isEqualTo(0)
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.FOURTH)).isEqualTo(0)
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.FIFTH)).isEqualTo(0)
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.ELSE)).isEqualTo(0)
    }

    @Test
    fun `1등 한명 2등 한명인 경우 테스트`() {
        val lottoTicket = LottoTicket(listOf(lotto1))
        lottoTicket.addTicket(LottoTicket(listOf(Lotto(listOf(1, 2, 3, 4, 5, 7).map { LottoNumber.from(it) }))))
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.FIRST)).isEqualTo(1)
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.SECOND)).isEqualTo(1)
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.THIRD)).isEqualTo(0)
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.FOURTH)).isEqualTo(0)
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.FIFTH)).isEqualTo(0)
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.ELSE)).isEqualTo(0)
    }
}
