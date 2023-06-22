package lotto

import lotto.domain.LottoNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoNumbersTest {

    @Test
    fun `발급된 로또 번호는 6개여야 한다`() {
        Assertions.assertThat(
            LottoNumbers.generate()
                .numbers
        ).hasSize(6)
    }

    @ParameterizedTest
    @MethodSource("숫자가 6개가 아닌 로또 번호")
    fun `로또 번호가 6개가 아니라면 throw IllegalStateException`(lottoNumbers: Set<Int>) {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers.fromNumbers(lottoNumbers)
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있다면 throw IllegalArgumentException`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers.fromNumbers(setOf(1, 1, 2, 3, 4, 5))
        }
    }

    @ParameterizedTest
    @MethodSource("범위를 벗어난 숫자가 있는 로또 번호")
    fun `로또 번호에 범위를 벗어난 숫자가 있다면 throw IllegalArgumentException`(lottoNumbers: Set<Int>) {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers.fromNumbers(lottoNumbers)
        }
    }

    @ParameterizedTest
    @MethodSource("겹치는 로또 번호 테스트 데이터")
    fun `겹치는 로또 번호 개수 구하기 테스트`(lottoNumbers1: Set<Int>, lottoNumbers2: Set<Int>, overlaps: Int) {
        Assertions.assertThat(
            LottoNumbers.fromNumbers(lottoNumbers1).numberOfOverlaps(LottoNumbers.fromNumbers(lottoNumbers2))
        ).isEqualTo(overlaps)
    }

    companion object {
        @JvmStatic
        fun `범위를 벗어난 숫자가 있는 로또 번호`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(setOf(-1, 1, 2, 3, 4, 5)),
                Arguments.of(setOf(1, 2, 3, 4, 5, 46)),
            )
        }

        @JvmStatic
        fun `숫자가 6개가 아닌 로또 번호`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(setOf(1, 2, 3, 4, 5)),
                Arguments.of(setOf(1, 2, 3, 4, 5, 6, 7)),
            )
        }

        @JvmStatic
        fun `겹치는 로또 번호 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(setOf(1, 2, 3, 4, 5, 6), setOf(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(setOf(1, 2, 3, 4, 5, 6), setOf(1, 12, 13, 14, 15, 16), 1),
                Arguments.of(setOf(1, 2, 3, 4, 5, 6), setOf(11, 12, 13, 14, 15, 16), 0),
            )
        }
    }
}
