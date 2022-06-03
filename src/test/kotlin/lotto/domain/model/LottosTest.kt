package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottosTest {
    @Test
    fun `Lottos는 발급받은 로또 번호들을 보관한다`() {
        val lottoList = listOf(
            Lotto.from(1, 2, 3, 4, 5, 6),
            Lotto.from(11, 12, 13, 14, 15, 16),
            Lotto.from(12, 22, 32, 24, 25, 26)
        )

        val lottos = Lottos(lottoList)

        assertThat(lottos.value).isEqualTo(lottoList)
    }

    @Test
    fun `checkWith를 통해 당첨 번호를 받아 LottoResult를 반환한다`() {
        val lottos = Lottos(
            listOf(
                Lotto.from(8, 21, 23, 41, 42, 43),
                Lotto.from(8, 21, 23, 41, 42, 44),
                Lotto.from(8, 21, 23, 41, 43, 44),
                Lotto.from(8, 21, 23, 41, 1, 2),
                Lotto.from(8, 21, 23, 1, 2, 3)
            )
        )

        val winningNumbers = WinningNumbers.from(Lotto.from(8, 21, 23, 41, 42, 43), LottoNumber[4])

        val lottoResult = lottos.checkWith(winningNumbers)

        assertAll(
            { assertThat(lottoResult[LottoRank.FIFTH].count).isEqualTo(1) },
            { assertThat(lottoResult[LottoRank.FOURTH].count).isEqualTo(1) },
            { assertThat(lottoResult[LottoRank.THIRD].count).isEqualTo(2) },
            { assertThat(lottoResult[LottoRank.FIRST].count).isEqualTo(1) }
        )
    }

    @Test
    fun `발급할 로또 개수와 LottoFactory를 받아 Lottos를 만들 수 있다`() {
        val lottos = Lottos.of(
            2,
            object : LottoFactory {
                override fun create(): Lotto {
                    return Lotto.from(1, 2, 3, 4, 5, 6)
                }
            }
        )

        assertThat(lottos.value.size).isEqualTo(2)
    }
}
