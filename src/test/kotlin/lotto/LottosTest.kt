package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

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
    fun `금액만큼 예상하는 번호로 자동구매 가능`() {
        val fixedLottoNumbersGenerator =
            FixedLottoNumbersGenerator(
                listOf(
                    setOf(1, 2, 3, 4, 5, 6),
                    setOf(14, 15, 16, 17, 18, 19),
                ),
            )
        val buyAmount = Amount("2500")

        val actual = Lottos.fromCount(buyAmount, fixedLottoNumbersGenerator)

        assertAll(
            {assertThat(actual.size).isEqualTo(2)},
            {assertThat(actual.ranks(Lotto.from(listOf(1, 2, 3, 4, 5, 6)))).isEqualTo(Ranks.fromGroupBy(listOf(Rank.FIRST, Rank.MISS)))},
        )
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
