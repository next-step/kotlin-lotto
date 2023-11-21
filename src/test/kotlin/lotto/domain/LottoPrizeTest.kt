package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoPrizeTest {
    @Test
    fun `로또 번호가 5개 일치하고, 보너스 번호가 포함되어 있다면 2등이다`() {
        // given
        val matchCount = 5
        val hasBonus = true

        // when
        val lottoPrize = LottoPrize.of(matchCount, hasBonus)

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.SECOND)
    }

    @Test
    fun `로또 번호가 5개 일치하고, 보너스 번호가 포함되어 있지 않다면 3등이다`() {
        // given
        val matchCount = 5
        val hasBonus = false

        // when
        val lottoPrize = LottoPrize.of(matchCount, hasBonus)

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.THIRD)
    }
}
