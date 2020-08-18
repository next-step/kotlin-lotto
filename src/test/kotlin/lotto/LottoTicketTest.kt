package lotto

import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.LottoTicket
import lotto.model.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {
    private val numbers = listOf(1, 2, 3, 4, 5, 6)
    private val lottoTicket = LottoTicket(emptyList())
    private val winningLotto = Lotto(numbers.map { LottoNumber.from(it) })

    @Test
    fun `로또 추가 테스트`() {
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.FIRST)).isEqualTo(0)
        lottoTicket.addTicket(LottoTicket(listOf(winningLotto)))
        assertThat(lottoTicket.gameResult(winningLotto, LottoNumber.from(7)).of(Rank.FIRST)).isEqualTo(1)
    }
}
