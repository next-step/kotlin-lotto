package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class LottoPrizeTest {
    @ParameterizedTest
    @MethodSource("getSecondPrize")
    fun `로또 번호가 5개 일치하고, 보너스 번호가 포함되어 있다면 2등이다`(matchCountHasBonusPair: Pair<Int, Boolean>) {
        // given
        val (matchCount, hasBonus) = matchCountHasBonusPair

        // when
        val lottoPrize = LottoPrize.of(matchCount, hasBonus)

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.SECOND)
    }

    @ParameterizedTest
    @MethodSource("getThirdPrize")
    fun `로또 번호가 5개 일치하고, 보너스 번호가 포함되어 있지 않다면 3등이다`(matchCountHasBonusPair: Pair<Int, Boolean>) {
        // given
        val (matchCount, hasBonus) = matchCountHasBonusPair

        // when
        val lottoPrize = LottoPrize.of(matchCount, hasBonus)

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.THIRD)
    }

    companion object {
        @JvmStatic
        fun getSecondPrize() = listOf(
            Pair(5, true),
        )

        @JvmStatic
        fun getThirdPrize() = listOf(
            Pair(5, false),
        )
    }
}
