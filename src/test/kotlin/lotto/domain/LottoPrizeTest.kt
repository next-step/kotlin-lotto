package lotto.domain

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class LottoPrizeTest {
    @ParameterizedTest
    @MethodSource("getMatchCountHasBonusPair")
    fun `보너스 일치 여부에 따라 2등과 3등이 정해진다`(matchCountHasBonusPair: Pair<Int, Boolean>) {
        // given
        val (matchCount, hasBonus) = matchCountHasBonusPair

        // when
        val lottoPrize = LottoPrize.of(matchCount, hasBonus)

        // then
        if (hasBonus) {
            assert(lottoPrize == LottoPrize.SECOND)
        } else {
            assert(lottoPrize == LottoPrize.THIRD)
        }
    }

    companion object {
        @JvmStatic
        fun getMatchCountHasBonusPair() = listOf(
            Pair(5, true),
            Pair(5, false),
        )
    }
}
