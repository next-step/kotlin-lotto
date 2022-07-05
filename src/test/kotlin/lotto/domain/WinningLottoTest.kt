package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class WinningLottoTest {
    @Test
    fun `Winning Lotto와 bonus number는 중복되면 안된다`() {
        val winningNumbers = Lotto((1..6).map { LottoNumber.of(it) })
        val bonusNumber = LottoNumber.of(6)

        assertThrows<IllegalArgumentException> { WinningLotto(winningNumbers, bonusNumber) }
    }

    @Test
    fun `Bonus number가 일치 한다`() {
        val winningLotto = WinningLotto(Lotto((1..6).map { LottoNumber.of(it) }), LottoNumber.of(10))
        val lotto = Lotto((10..15).map { LottoNumber.of(it) })

        assertThat(winningLotto.matchedBonus(lotto)).isTrue
    }

    @Test
    fun `Bonus number가 일치 하지 않는다`() {
        val winningLotto = WinningLotto(Lotto((1..6).map { LottoNumber.of(it) }), LottoNumber.of(10))
        val lotto = Lotto((1..6).map { LottoNumber.of(it) })

        assertThat(winningLotto.matchedBonus(lotto)).isFalse
    }

    @ParameterizedTest
    @MethodSource("lottoRankArguments")
    fun `Winning Lotto can calculate rank`(lotto: Lotto, rank: Rank) {
        val winningLotto = WinningLotto(Lotto(1, 2, 3, 4, 5, 6), LottoNumber.of(7))

        assertThat(winningLotto.rank(lotto)).isEqualTo(rank)
    }

    companion object {
        @JvmStatic
        fun lottoRankArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Lotto(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(Lotto(1, 2, 3, 4, 5, 7), Rank.SECOND),
                Arguments.of(Lotto(1, 2, 3, 4, 5, 8), Rank.THIRD),
                Arguments.of(Lotto(1, 2, 3, 4, 7, 9), Rank.FOURTH),
                Arguments.of(Lotto(1, 2, 3, 4, 8, 9), Rank.FOURTH),
                Arguments.of(Lotto(1, 2, 3, 7, 8, 9), Rank.FIFTH),
                Arguments.of(Lotto(1, 2, 7, 8, 9, 10), Rank.LOSE),
                Arguments.of(Lotto(1, 7, 8, 9, 10, 11), Rank.LOSE),
                Arguments.of(Lotto(11, 12, 13, 14, 15, 16), Rank.LOSE),
            )
        }
    }
}
