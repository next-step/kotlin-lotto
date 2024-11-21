package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `Lottos는 Lotto를 가진다`() {
        val lottos =
            Lottos(
                listOf(
                    Lotto.from(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto.from(listOf(1, 2, 3, 4, 5, 6)),
                ),
            )

        assertThat(lottos.size).isEqualTo(2)
    }

    @Test
    fun `금액만큼 자동구매 가능`() {
        val fixedLottoNumbersGenerator =
            FixedLottoNumbersGenerator(
                listOf(
                    setOf(1, 2, 3, 4, 5, 6),
                    setOf(4, 5, 6, 7, 8, 9),
                    setOf(11, 12, 13, 14, 15, 16),
                    setOf(21, 22, 23, 24, 25, 26),
                ),
            )
        val buyAmount = Amount("4500")

        val actual = Lottos.fromCount(buyAmount, fixedLottoNumbersGenerator)

        assertThat(actual.size).isEqualTo(4)
    }

    @Test
    fun `당첨갯수 확인`() {
        val lottos =
            Lottos(
                listOf(
                    Lotto.from(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto.from(listOf(1, 2, 3, 4, 5, 7)),
                ),
            )
        val lastLotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))

        val actual: Ranks = lottos.ranks(lastLotto)

        assertThat(actual).isEqualTo(Ranks.fromGroupBy(listOf(Rank.FIRST, Rank.SECOND)))
    }
}
