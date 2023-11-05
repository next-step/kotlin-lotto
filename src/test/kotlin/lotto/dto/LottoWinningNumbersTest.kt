package lotto.dto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoWinningNumbersTest {
    @Test
    fun `로또 당첨 번호 생성`() {
        val lottoWinningNumbers = LottoWinningNumbers(
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
            7
        )
        assertThat(lottoWinningNumbers.lottoNumbers.numbers.size).isEqualTo(6)
        assertThat(lottoWinningNumbers.lottoNumbers).isEqualTo(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)))
        assertThat(lottoWinningNumbers.bonusNumber).isEqualTo(LottoNumber(7))
    }

    @Test
    fun `보너스 번호가 당첨 번호에 포함되면 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            LottoWinningNumbers(
                LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                6
            )
        }
    }

    @ParameterizedTest
    @MethodSource("lottoCandidates")
    fun `로또 당첨 번호 비교`(lottoNumbers: LottoNumbers, expected: LottoPrice) {
        val lottoWinningNumbers = LottoWinningNumbers(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 7)
        assertThat(lottoWinningNumbers.compareLottoNumbers(lottoNumbers)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun lottoCandidates(): Stream<Arguments> = Stream.of(
            Arguments.arguments(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), LottoPrice.ALL_MATCHED),
            Arguments.arguments(LottoNumbers(listOf(1, 2, 3, 4, 5, 7)), LottoPrice.FIVE_MATCHED_WITH_BONUS),
            Arguments.arguments(LottoNumbers(listOf(1, 2, 3, 4, 5, 8)), LottoPrice.FIVE_MATCHED),
            Arguments.arguments(LottoNumbers(listOf(1, 2, 3, 4, 8, 7)), LottoPrice.FOUR_MATCHED),
            Arguments.arguments(LottoNumbers(listOf(1, 2, 3, 9, 8, 7)), LottoPrice.THREE_MATCHED),
            Arguments.arguments(LottoNumbers(listOf(1, 2, 10, 9, 8, 7)), LottoPrice.TWO_MATCHED),
            Arguments.arguments(LottoNumbers(listOf(1, 11, 10, 9, 8, 7)), LottoPrice.ONE_MATCHED),
            Arguments.arguments(LottoNumbers(listOf(12, 11, 10, 9, 8, 7)), LottoPrice.NOT_MATCHED)
        )
    }
}
