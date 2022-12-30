package lotto.domain

import lotto.model.LottoNumber
import lotto.model.LottoNumbers
import lotto.model.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LottoTest {

    @ParameterizedTest
    @MethodSource("provideUserLottoAndRank")
    fun `당첨된 로또 등수를 알 수 있다`(userLotto: Lotto, rank: Rank) {
        // given
        val winningLottoNumbers = (1..6).map(::LottoNumber)
        val bonusNumber = LottoNumber(7)
        val winningLotto = WinningLotto(winningLottoNumbers, bonusNumber)

        // when
        val result = userLotto.matches(winningLotto)

        // then
        assertThat(result.count(rank)).isEqualTo(1)
    }

    @Test
    fun `로또 번호 꽝 확인`() {
        // given
        val userLottoNumbers = listOf(
            LottoNumbers((1..6).map(::LottoNumber))
        )
        val userLotto = Lotto(userLottoNumbers)
        val winningLotto = WinningLotto((7..12).map(::LottoNumber), LottoNumber(8))

        // when
        val result = userLotto.matches(winningLotto)

        // then
        assertThat(result.size).isEqualTo(0)
    }

    companion object {
        @JvmStatic
        fun provideUserLottoAndRank(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Lotto(listOf(LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)))),
                    Rank.FIRST
                ),
                Arguments.of(
                    Lotto(listOf(LottoNumbers(listOf(1, 2, 3, 4, 5, 7).map(::LottoNumber)))),
                    Rank.SECOND
                ),
                Arguments.of(
                    Lotto(listOf(LottoNumbers(listOf(1, 2, 3, 4, 5, 8).map(::LottoNumber)))),
                    Rank.THIRD
                ),
                Arguments.of(
                    Lotto(listOf(LottoNumbers(listOf(1, 2, 3, 4, 8, 9).map(::LottoNumber)))),
                    Rank.FOURTH
                ),
                Arguments.of(
                    Lotto(listOf(LottoNumbers(listOf(1, 2, 3, 8, 9, 10).map(::LottoNumber)))),
                    Rank.FIFTH
                )
            )
        }
    }
}
