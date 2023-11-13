package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {

    @Test
    fun `로또를 생성한다`() {
        val lottos = Lottos(
            listOf(
                createLotto(1, 2, 3, 4, 5, 6)
            )
        )
        assertThat(lottos.lottos).hasSize(1)
    }

    @Test
    fun `로또의 등수를 확인한다`() {
        val lottos = Lottos(
            listOf(
                createLotto(1, 2, 3, 4, 5, 6),
                createLotto(1, 2, 3, 4, 5, 6),
                createLotto(1, 2, 3, 4, 5, 7)
            )
        )
        val winningLotto = WinningLotto(
            createLotto(1, 2, 3, 4, 5, 6)
        )
        val lottoRanks = lottos.getLottoRanks(winningLotto)
        assertThat(lottoRanks[LottoRank.FIRST]).isEqualTo(2)
        assertThat(lottoRanks[LottoRank.SECOND]).isEqualTo(1)
    }

    private fun createLotto(vararg numbers: Int): Lotto {
        return Lotto(
            numbers.map { LottoNumber.of(it) }
        )
    }
}
