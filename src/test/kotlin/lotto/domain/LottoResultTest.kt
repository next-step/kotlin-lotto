package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoResultTest {

    @Test
    fun `로또의 당첨 통계를 구한다`() {
        // given
        val winLotto = Lotto(1, 2, 3, 4, 5, 6)
        val fourthLotto = Lotto(1, 2, 3, 7, 8, 9)
        val missLotto = Lotto(7, 8, 9, 10, 11, 12)
        val lottoPaper = LottoPaper(listOf(fourthLotto, missLotto))

        // when
        val lottoStatistics: LottoStatistics = lottoPaper.result(Money(10_000), winLotto)

        // then
        assertThat(lottoStatistics.earningsRate).isEqualTo(0.5)
    }
}
