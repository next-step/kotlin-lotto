package lotto.dto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoNumbersTest {
    @Test
    fun `로또 번호 생성`() {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        assert(lottoNumbers.numbers.size == 6)
    }

    @Test
    fun `로또 번호 숫자가 6개가 아닌 경우 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 숫자가 중복되면 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @ParameterizedTest
    @MethodSource("lottoCandidates")
    fun `로또 숫자 비교`(compareLotto: LottoNumbers, expected: Int) {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lottoNumbers.matchedLottoNumberCount(compareLotto)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun lottoCandidates(): Stream<Arguments> = Stream.of(
            Arguments.arguments(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 6),
            Arguments.arguments(LottoNumbers(listOf(1, 2, 3, 4, 5, 7)), 5),
            Arguments.arguments(LottoNumbers(listOf(1, 2, 3, 4, 8, 7)), 4),
            Arguments.arguments(LottoNumbers(listOf(1, 2, 3, 9, 8, 7)), 3),
            Arguments.arguments(LottoNumbers(listOf(1, 2, 10, 9, 8, 7)), 2),
            Arguments.arguments(LottoNumbers(listOf(1, 11, 10, 9, 8, 7)), 1),
            Arguments.arguments(LottoNumbers(listOf(12, 11, 10, 9, 8, 7)), 0)
        )
    }
}
