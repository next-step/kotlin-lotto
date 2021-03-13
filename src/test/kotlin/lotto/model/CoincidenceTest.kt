package lotto.model

import lotto.model.game.Lotto
import lotto.model.game.LottoNumber
import lotto.model.game.Lottos
import lotto.model.game.WinningLotto
import lotto.model.result.Coincidence
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CoincidenceTest {
    @Test
    fun `나의 Lotto와 WinningLotto(보너스볼+당첨번호)를 인자로 주면, match 결과를 반환한다 (2등인 경우)`() {
        // given
        val myLotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))

        // when
        val matchResult: Coincidence = Coincidence.match(myLotto, winningLotto)

        // then
        assertThat(matchResult).isEqualTo(Coincidence.SECOND)
    }

    @Test
    fun `나의 Lotto와 WinningLotto(보너스볼+당첨번호)를 인자로 주면, match 결과를 반환한다 (꽝인 경우)`() {
        // given
        val myLotto = Lotto(listOf(11, 12, 13, 4, 5, 7))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))

        // when
        val matchResult: Coincidence = Coincidence.match(myLotto, winningLotto)

        // then
        assertThat(matchResult).isEqualTo(Coincidence.MISS)
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    fun `나의 Lottos를 주면, Coincidence 상태와 match되는 Lotto 갯수 반환`(coincidence: Coincidence, expectedCount: Int) {
        val myLotto1 = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val myLotto2 = Lotto(listOf(1, 2, 3, 14, 15, 17))
        val myLottos = Lottos(listOf(myLotto1, myLotto2))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))

        // when
        val matchCount = coincidence.getMatchedCount(myLottos, winningLotto)

        // then
        assertThat(matchCount).isEqualTo(expectedCount)
    }

    companion object {
        @JvmStatic
        private fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                arguments(Coincidence.FIRST, 0),
                arguments(Coincidence.SECOND, 1),
                arguments(Coincidence.THIRD, 0),
                arguments(Coincidence.FOURTH, 0),
                arguments(Coincidence.FIFTH, 1)
            )
        }
    }
}
