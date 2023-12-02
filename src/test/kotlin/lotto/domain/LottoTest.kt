package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoTest {

    @ParameterizedTest
    @MethodSource("provideLotto")
    fun `번호를 매치하면 MatchedLotto로 변경된다`(lotto: Lotto, expectedWinning: LottoWinning) {
        val winningLotto = WinningLotto(Lotto.of(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))
        val matchedLotto = lotto.match(winningLotto)

        val actualWinning = matchedLotto.winning

        assertThat(actualWinning).isEqualTo(expectedWinning)
    }

    companion object {
        @JvmStatic
        private fun provideLotto(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Lotto.of(listOf(1, 2, 3, 10, 11, 12)), LottoWinning.Fifth),
                Arguments.of(Lotto.of(listOf(1, 2, 3, 4, 11, 12)), LottoWinning.Fourth),
                Arguments.of(Lotto.of(listOf(1, 2, 3, 4, 5, 12)), LottoWinning.Third),
                Arguments.of(Lotto.of(listOf(1, 2, 3, 4, 5, 7)), LottoWinning.Second),
                Arguments.of(Lotto.of(listOf(1, 2, 3, 4, 5, 6)), LottoWinning.First),
            )
        }
    }
}
