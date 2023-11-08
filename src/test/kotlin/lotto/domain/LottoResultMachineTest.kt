package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class LottoResultMachineTest {
    private val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

    @ParameterizedTest
    @MethodSource("lottoAndPrizePairList")
    fun `일치 개수에 따라 순위가 정해진다`(lottoAndPrizePair: Pair<Lotto, LottoPrize>) {
        // given
        val lotto = lottoAndPrizePair.first
        val expectedPrize = lottoAndPrizePair.second

        // when
        val lottoResult = LottoResultMachine.checkWinningLotto(winningLotto, lotto)

        // then
        assertThat(lottoResult.prize).isEqualTo(expectedPrize)
    }

    companion object {
        @JvmStatic
        fun lottoAndPrizePairList(): List<Pair<Lotto, LottoPrize>> {
            return listOf(
                Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoPrize.FIRST),
                Pair(Lotto(listOf(1, 2, 3, 4, 5, 7)), LottoPrize.SECOND),
                Pair(Lotto(listOf(1, 2, 3, 4, 7, 8)), LottoPrize.THIRD),
                Pair(Lotto(listOf(1, 2, 3, 7, 8, 9)), LottoPrize.FOURTH),
                Pair(Lotto(listOf(1, 2, 7, 8, 9, 10)), LottoPrize.MISS)
            )
        }
    }
}
