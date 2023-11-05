package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoWinningCheckerTest {
    @ParameterizedTest
    @MethodSource("provideLottos")
    fun `당첨 번호가 포함되어있으면 Winning 값을 변경해준다`(lotto: Lotto, expectedWinning: LottoWinning) {
        val checkedLotto = LottoWinningChecker.check(listOf(lotto), listOf(1, 2, 3, 4, 5, 6))

        val actualWinning = checkedLotto.first().winning

        assertThat(actualWinning).isEqualTo(expectedWinning)
    }

    companion object {
        @JvmStatic
        private fun provideLottos(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Lotto(listOf(1, 2, 3, 10, 11, 12)), LottoWinning.CorrectThree),
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 11, 12)), LottoWinning.CorrectFour),
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 5, 12)), LottoWinning.CorrectFive),
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoWinning.CorrectSix),
            )
        }
    }
}
