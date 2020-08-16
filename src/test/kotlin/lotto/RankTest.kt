package lotto

import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    private val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })

    @Test
    fun `1위 테스트`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val targetLotto = Lotto(numbers.map { LottoNumber.from(it) })
        assertThat(
            Rank.of(
                targetLotto.matchCount(winningLotto),
                targetLotto.matchBonus(LottoNumber.from(7))
            )
        ).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `2위 테스트`() {
        val numbers = listOf(1, 2, 3, 4, 5, 7)
        val targetLotto = Lotto(numbers.map { LottoNumber.from(it) })
        assertThat(
            Rank.of(
                targetLotto.matchCount(winningLotto),
                targetLotto.matchBonus(LottoNumber.from(7))
            )
        ).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `3위 테스트`() {
        val numbers = listOf(1, 2, 3, 4, 5, 9)
        val targetLotto = Lotto(numbers.map { LottoNumber.from(it) })
        assertThat(
            Rank.of(
                targetLotto.matchCount(winningLotto),
                targetLotto.matchBonus(LottoNumber.from(7))
            )
        ).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `4위 테스트`() {
        val numbers = listOf(1, 2, 3, 4, 9, 9)
        val targetLotto = Lotto(numbers.map { LottoNumber.from(it) })
        assertThat(
            Rank.of(
                targetLotto.matchCount(winningLotto),
                targetLotto.matchBonus(LottoNumber.from(7))
            )
        ).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `5위 테스트`() {
        val numbers = listOf(1, 2, 3, 9, 9, 9)
        val targetLotto = Lotto(numbers.map { LottoNumber.from(it) })
        assertThat(
            Rank.of(
                targetLotto.matchCount(winningLotto),
                targetLotto.matchBonus(LottoNumber.from(7))
            )
        ).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `2개 맞았을 때 테스트`() {
        val numbers = listOf(1, 2, 9, 9, 9, 9)
        val targetLotto = Lotto(numbers.map { LottoNumber.from(it) })
        assertThat(
            Rank.of(
                targetLotto.matchCount(winningLotto),
                targetLotto.matchBonus(LottoNumber.from(7))
            )
        ).isEqualTo(Rank.ELSE)
    }

    @Test
    fun `1개 맞았을 때 테스트`() {
        val numbers = listOf(1, 9, 9, 9, 9, 9)
        val targetLotto = Lotto(numbers.map { LottoNumber.from(it) })
        assertThat(
            Rank.of(
                targetLotto.matchCount(winningLotto),
                targetLotto.matchBonus(LottoNumber.from(7))
            )
        ).isEqualTo(Rank.ELSE)
    }

    @Test
    fun `0개 맞았을 때 테스트`() {
        val numbers = listOf(9, 9, 9, 9, 9, 9)
        val targetLotto = Lotto(numbers.map { LottoNumber.from(it) })
        assertThat(
            Rank.of(
                targetLotto.matchCount(winningLotto),
                targetLotto.matchBonus(LottoNumber.from(7))
            )
        ).isEqualTo(Rank.ELSE)
    }
}