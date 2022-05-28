package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoScoreTest {
    @Test
    internal fun `당첨 번호와 나의 로또 번호를 비교하여 결과를 반환한다`() {
        val lottoTicket = LottoTicket(1, 2, 3, 4, 5, 6)
        val winningTicket = LottoTicket(1, 7, 8, 9, 2, 3)

        val result = LottoScore().compareNumber(winningTicket, listOf(lottoTicket)).first()
        assertThat(result.lottoCount).isEqualTo(1)
        assertThat(result.lottoPrize).isEqualTo(LottoPrize.THREE_MATCH)
    }

    private fun LottoTicket(vararg numbers: Int) =
        LottoTicket(numbers.map { LottoNumber(it) }.toSet())
}
