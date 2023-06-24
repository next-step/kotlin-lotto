package lotto

import lotto.domain.LottoNumbers
import lotto.domain.LottoWinningNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class LottoWinningNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `보너스 번호가 유요한 범위 내의 숫자가 아니라면 throw IllegalArgumentException`(bonusNumber: Int) {
        assertThrows<IllegalArgumentException> {
            LottoWinningNumbers(LottoNumbers(setOf(1, 2, 3, 4, 5, 6)), bonusNumber)
        }
    }

    @Test
    fun `보너스 번호가 다른 로또 번호와 중복이라면 throw IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            LottoWinningNumbers(LottoNumbers(setOf(1, 2, 3, 4, 5, 6)), 1)
        }
    }

    @ParameterizedTest
    @MethodSource("겹치는 로또 번호 테스트 데이터")
    fun `겹치는 로또 번호 개수 구하기 테스트`(winningNumbers: LottoWinningNumbers, lottoNumbers: LottoNumbers, overlaps: Int) {
        Assertions.assertThat(
            winningNumbers.numberOfOverlaps(lottoNumbers)
        ).isEqualTo(overlaps)
    }

    @ParameterizedTest
    @MethodSource("2등 확인 테스트 데이터")
    fun `2등 확인 테스트`(winningNumbers: LottoWinningNumbers, lottoNumbers: LottoNumbers, isSecond: Boolean) {
        Assertions.assertThat(
            winningNumbers.isSecondPlace(lottoNumbers)
        ).isEqualTo(isSecond)
    }

    companion object {
        @JvmStatic
        fun `2등 확인 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    LottoWinningNumbers(
                        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)), 7
                    ),
                    LottoNumbers(setOf(2, 3, 4, 5, 6, 7)),
                    true
                ),
                Arguments.of(
                    LottoWinningNumbers(
                        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)), 7
                    ),
                    LottoNumbers(setOf(1, 2, 3, 4, 5, 6)),
                    false
                )
            )
        }

        @JvmStatic
        fun `겹치는 로또 번호 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    LottoWinningNumbers(
                        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)), 7
                    ),
                    LottoNumbers(setOf(1, 2, 3, 4, 5, 6)),
                    6
                ),
                Arguments.of(
                    LottoWinningNumbers(
                        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)), 7
                    ),
                    LottoNumbers(setOf(1, 12, 13, 14, 15, 16)),
                    1
                ),
                Arguments.of(
                    LottoWinningNumbers(
                        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)), 7
                    ),
                    LottoNumbers(setOf(11, 12, 13, 14, 15, 16)),
                    0
                ),
            )
        }
    }
}
