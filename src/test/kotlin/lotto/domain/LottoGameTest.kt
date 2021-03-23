package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LottoGameTest {

    @ParameterizedTest
    @MethodSource("lotto")
    fun `각등수의 로또 번호 2개가 들어 있는 경우`(lotto1: Lotto, lotto2: Lotto, lottoRank: LottoRank) {
        val lotto3 = Lotto(45, 44, 43, 42, 41, 40)
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val lottoGame = LottoGame(listOf(lotto1, lotto2, lotto3))
        assertThat(lottoGame.matchLotto(winningLotto)[lottoRank]).isEqualTo(2)
    }

    companion object {
        @JvmStatic
        fun lotto() = listOf(
            Arguments.of(
                Lotto(1, 7, 3, 4, 9, 11),
                Lotto(1, 8, 3, 4, 10, 12),
                LottoRank.FOURTH
            ),
            Arguments.of(
                Lotto(1, 2, 3, 4, 9, 11),
                Lotto(1, 2, 3, 4, 10, 12),
                LottoRank.THIRD
            ),
            Arguments.of(
                Lotto(1, 2, 3, 4, 5, 11),
                Lotto(1, 2, 3, 4, 5, 12),
                LottoRank.SECOND
            ),
            Arguments.of(
                Lotto(1, 2, 3, 4, 5, 6),
                Lotto(1, 2, 3, 4, 5, 6),
                LottoRank.FIRST
            )
        )

        private fun Lotto(vararg numbers: Int): Lotto {
            return Lotto(numbers.map { LottoNumber.from(it) })
        }
    }
}
