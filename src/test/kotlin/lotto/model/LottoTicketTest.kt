package lotto.model

import lotto.model.game.LottoTicket
import lotto.model.game.Lotto
import lotto.model.game.LottoNumber
import lotto.model.game.Lottos
import lotto.model.game.WinningLotto
import lotto.model.result.Coincidence
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LottoTicketTest {
    @ParameterizedTest
    @MethodSource("provideParameters")
    fun `나의 Lotto와 WinningLotto(보너스볼+당첨번호)를 인자로 주면, match 결과를 반환한다 (2등인 경우)`(coincidence: Coincidence, matchedCount: Int) {
        // given
        val myLotto1 = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val myLotto2 = Lotto(listOf(1, 2, 3, 4, 5, 12))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))
        val myLottos = Lottos(listOf(myLotto1, myLotto2))
        val lottoTicket = LottoTicket(myLottos, winningLotto)

        // when
        val matchedLottoCount = lottoTicket.getMatchedLottoCount(coincidence)

        // then
        assertThat(matchedLottoCount).isEqualTo(matchedCount)
    }

    companion object {
        @JvmStatic
        fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(Coincidence.FIRST, 0),
                Arguments.arguments(Coincidence.SECOND, 1),
                Arguments.arguments(Coincidence.THIRD, 1),
                Arguments.arguments(Coincidence.FOURTH, 0),
                Arguments.arguments(Coincidence.FIFTH, 0)
            )
        }
    }
}
