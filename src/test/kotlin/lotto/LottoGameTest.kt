package lotto

import lotto.domain.LottoGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoGameTest {
    @ParameterizedTest
    @MethodSource("lottoNumbersData")
    fun `lottoGame에 입력된 숫자들의 값 과 위치가 변경 되지 않는다`(lottoNumbers: List<Int>) {
        val lottoGame = LottoGame(lottoNumbers)
        val expected = lottoNumbers
        val actual = lottoGame.getNumbers()
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun lottoNumbersData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of(listOf(2, 4, 8, 10, 15, 33))
            )
        }
    }
}
