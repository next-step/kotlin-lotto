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
        val actualLottoWinning = LottoWinning.of(correctCount, false)

        assertThat(actualLottoWinning).isEqualTo(expectedLottoWinning)
    }

    @Test
    fun `매칭된 숫자가 5개면서 보너스 숫자를 맞추면 2등이다`() {
        val winning = LottoWinning.of(5, true)

        assertThat(winning).isEqualTo(LottoWinning.Second)
    }

    @Test
    fun `당첨된 숫자 개수는 0 보다 작을 수 없다`() {
        assertThrows<IllegalArgumentException> {
            LottoWinning.of(-1, false)
        }
    }

    @Test
    fun `당첨된 숫자 개수는 6 보다 많을 수 없다`() {
        assertThrows<IllegalArgumentException> {
            LottoWinning.of(7, false)
        }
    }

    companion object {
        @JvmStatic
        private fun provideWinnings(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(0, LottoWinning.Miss),
                Arguments.of(1, LottoWinning.Miss),
                Arguments.of(2, LottoWinning.Miss),
                Arguments.of(3, LottoWinning.Fifth),
                Arguments.of(4, LottoWinning.Fourth),
                Arguments.of(5, LottoWinning.Third),
                Arguments.of(6, LottoWinning.First),
            )
        }
    }
}
