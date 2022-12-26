package lotto.domain

import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.LottoPrize
import lotto.model.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LottoMatcherTest {

    @Test
    fun `1등 당첨`() {
        // given
        val winningLotto =
            listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).let(::WinningLotto)
        val userLotto =
            listOf(Lotto(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)))

        // when
        val lottoPrizeResults = LottoMatcher().match(winningLotto, userLotto)

        // then
        assertThat(lottoPrizeResults.count(LottoPrize.FIRST)).isEqualTo(1)
    }

    @Test
    fun `2등 당첨`() {
        // given
        val winningLotto =
            listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).let(::WinningLotto)
        val userLotto =
            listOf(Lotto(listOf(1, 2, 3, 4, 5, 7).map(::LottoNumber)))

        // when
        val lottoPrizeResults = LottoMatcher().match(winningLotto, userLotto)

        // then
        assertThat(lottoPrizeResults.count(LottoPrize.SECOND)).isEqualTo(1)
    }

    @Test
    fun `3등 당첨`() {
        // given
        val winningLotto =
            listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).let(::WinningLotto)
        val userLotto =
            listOf(Lotto(listOf(1, 2, 3, 4, 7, 8).map(::LottoNumber)))

        // when
        val lottoPrizeResults = LottoMatcher().match(winningLotto, userLotto)

        // then
        assertThat(lottoPrizeResults.count(LottoPrize.THIRD)).isEqualTo(1)
    }

    @Test
    fun `4등 당첨`() {
        // given
        val winningLotto =
            listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).let(::WinningLotto)
        val userLotto =
            listOf(Lotto(listOf(1, 2, 3, 7, 8, 9).map(::LottoNumber)))

        // when
        val lottoPrizeResults = LottoMatcher().match(winningLotto, userLotto)

        // then
        assertThat(lottoPrizeResults.count(LottoPrize.FOURTH)).isEqualTo(1)
    }

    @ParameterizedTest
    @MethodSource("provideLosingLotto")
    fun `꽝(담청 결과 없음)`(userLotto: List<Lotto>) {
        // given
        val winningLotto =
            listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).let(::WinningLotto)
        // when
        val lottoPrizeResults = LottoMatcher().match(winningLotto, userLotto)

        // then
        assertThat(lottoPrizeResults.size == 0).isTrue
    }

    companion object {
        @JvmStatic
        fun provideLosingLotto(): Stream<List<Lotto>> {
            return Stream.of(
                listOf(Lotto(listOf(1, 12, 13, 7, 8, 9).map(::LottoNumber))),
                listOf(Lotto(listOf(1, 2, 13, 7, 8, 9).map(::LottoNumber))),
                listOf(Lotto(listOf(11, 12, 13, 7, 8, 9).map(::LottoNumber)))
            )
        }
    }
}
