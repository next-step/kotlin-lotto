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
import org.junit.jupiter.params.provider.MethodSource
import java.math.RoundingMode
import java.util.stream.Stream

internal class LottosTest {
    @Test
    fun `구매할 수 있는 로또 갯수를 인자로 주면, 해당 갯수만큼 Lotto를 가진 Lottos 객체가 생성된다`() {
        // given
        val lottoCount = 5

        // when
        val myLottos = Lottos(lottoCount)

        // then
        assertThat(myLottos.lottos.size).isEqualTo(5)
    }

    @Test
    fun `당첨번호를 인자로 주면, 수익률을 반환한다`() {
        // given
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 43, 44, 45)), // 3개 일치
                Lotto(listOf(7, 8, 9, 10, 11, 12)),
                Lotto(listOf(13, 14, 15, 16, 17, 18)),
                Lotto(listOf(19, 20, 21, 22, 23, 24)),
                Lotto(listOf(25, 26, 27, 28, 29, 30)),
                Lotto(listOf(31, 32, 33, 34, 35, 36))
            )
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val earningRate = lottos.getEarningRate(Lotto(winningNumbers))

        // then
        assertThat(earningRate).isEqualTo(5000.toBigDecimal().divide(6000.toBigDecimal(), 2, RoundingMode.FLOOR))
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    fun `Coincidence를 인자로 주면, 해당하는 로또 갯수를 반환한다`(coincidence: Coincidence, expectedCount: Int) {
        // given
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 8, 9)),
                Lotto(listOf(1, 2, 3, 4, 10, 11)),
                Lotto(listOf(1, 2, 3, 33, 35, 36)),
                Lotto(listOf(1, 2, 3, 43, 44, 45))
            )
        )
        val winningLotto = WinningLotto(Lotto("1, 2, 3, 4, 5, 6"), LottoNumber(7))

        // when
        val count = lottos.getCoincidenceCount(coincidence, winningLotto)

        // then
        assertThat(count).isEqualTo(expectedCount)
    }

    companion object {
        @JvmStatic
        private fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(Coincidence.FIRST, 1),
                Arguments.arguments(Coincidence.SECOND, 1),
                Arguments.arguments(Coincidence.THIRD, 0),
                Arguments.arguments(Coincidence.FOURTH, 2),
                Arguments.arguments(Coincidence.FIFTH, 2)
            )
        }
    }
}
