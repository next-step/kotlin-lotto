package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoWinningTest {
    @ParameterizedTest
    @MethodSource("provideWinnings")
    fun `당첨된 숫자에 맞는 Winning 이 생성된다`(correctCount: Int, expectedLottoWinning: LottoWinning) {
        val actualLottoWinning = LottoWinning.of(correctCount)

        assertThat(actualLottoWinning).isEqualTo(expectedLottoWinning)
    }

    @Test
    fun `당첨된 숫자 개수는 0 보다 작을 수 없다`() {
        assertThrows<IllegalArgumentException> {
            LottoWinning.of(-1)
        }
    }

    @Test
    fun `당첨된 숫자 개수는 6 보다 많을 수 없다`() {
        assertThrows<IllegalArgumentException> {
            LottoWinning.of(7)
        }
    }

    companion object {
        @JvmStatic
        private fun provideWinnings(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(0, LottoWinning.Nothing),
                Arguments.of(1, LottoWinning.Nothing),
                Arguments.of(2, LottoWinning.Nothing),
                Arguments.of(3, LottoWinning.CorrectThree),
                Arguments.of(4, LottoWinning.CorrectFour),
                Arguments.of(5, LottoWinning.CorrectFive),
                Arguments.of(6, LottoWinning.CorrectSix),
            )
        }
    }
}
