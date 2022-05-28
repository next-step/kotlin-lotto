package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottosTest {
    @Test
    fun `Lottos는 발급받은 로또 번호들을 보관한다`() {
        val lottoList = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(11, 12, 13, 14, 15, 16)),
            Lotto(listOf(12, 22, 32, 24, 25, 26))
        )

        val lottos = Lottos(lottoList)

        assertThat(lottos.value).isEqualTo(lottoList)
    }

    @Test
    fun `checkWith를 통해 당첨 번호를 받아 LottoResult를 반환한다`() {
        val lottos = Lottos(
            listOf(
                Lotto(listOf(8, 21, 23, 41, 42, 43)),
                Lotto(listOf(8, 21, 23, 41, 42, 44)),
                Lotto(listOf(8, 21, 23, 41, 43, 44)),
                Lotto(listOf(8, 21, 23, 41, 1, 2)),
                Lotto(listOf(8, 21, 23, 1, 2, 3))
            )
        )

        val winningNumbers = WinningNumbers(listOf(8, 21, 23, 41, 42, 43))

        val lottoResult = lottos.checkWith(winningNumbers)

        assertAll(
            { assertThat(lottoResult[LottoRank.FOURTH].count).isEqualTo(1) },
            { assertThat(lottoResult[LottoRank.THIRD].count).isEqualTo(1) },
            { assertThat(lottoResult[LottoRank.SECOND].count).isEqualTo(2) },
            { assertThat(lottoResult[LottoRank.FIRST].count).isEqualTo(1) }
        )
    }
}
