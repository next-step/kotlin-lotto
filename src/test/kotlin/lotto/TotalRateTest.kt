package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoResults
import lotto.domain.Lottos
import lotto.domain.TotalRate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal
import java.util.stream.Stream

class TotalRateTest {

    @Test
    fun `총 상금이 0원이면 수익률은 0퍼이다`() {
        // given
        val winningNumber = LottoNumbers.generateLottoNumbers(listOf(1, 2, 3, 4, 5, 6))

        val lottoResults = LottoResults.matchingWinningNumber(
            purchasedLottos = Lottos.from(
                listOf(
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 2, 11, 7, 8, 9))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 2, 7, 8, 9, 10))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 7, 8, 9, 10, 11))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 7, 8, 9, 10, 11))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 7, 8, 9, 10, 11)))
                )
            ),
            winningLottoNumbers = winningNumber,
            bonusLottoNumber = LottoNumber(7)
        )

        // when
        val totalRate = TotalRate.calculatingOf(lottoResults).getBenefit()

        // then
        assertThat(totalRate).isEqualByComparingTo(0.toBigDecimal())
    }

    @Test
    fun `총 예산이 5000인 경우(lotto가 5개인 경우) 당청 상금과 비슷한 경우에는 총 수익률은 1퍼이다`() {
        // given
        val winningNumber = LottoNumbers.generateLottoNumbers(listOf(1, 2, 3, 4, 5, 6))

        val lottoResults = LottoResults.matchingWinningNumber(
            purchasedLottos = Lottos.from(
                listOf(
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 2, 3, 7, 8, 9))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 2, 7, 8, 9, 10))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 7, 8, 9, 10, 11))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 7, 8, 9, 10, 11))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 7, 8, 9, 10, 11)))
                )
            ),
            winningLottoNumbers = winningNumber,
            bonusLottoNumber = LottoNumber(7)
        )

        // when
        val totalRate = TotalRate.calculatingOf(lottoResults).getBenefit()

        // then
        assertThat(totalRate).isEqualByComparingTo(1.00.toBigDecimal())
    }

    @ParameterizedTest
    @MethodSource("generateWinningNumbers")
    fun `여러 winningNumber 속에서 총 수익률이 일치하는지 테스트`(winningNumber: List<Int>, expectedTotalRate: BigDecimal) {
        // given
        val lottoResults = LottoResults.matchingWinningNumber(
            purchasedLottos = Lottos.from(
                listOf(
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(8, 21, 23, 41, 42, 43))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 2, 5, 7, 10, 12))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(10, 14, 17, 35, 36, 45))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 2, 3, 5, 6, 42))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 2, 3, 5, 6, 42)))
                )
            ),
            winningLottoNumbers = LottoNumbers.generateLottoNumbers(winningNumber),
            bonusLottoNumber = LottoNumber(7)
        )

        // when
        val totalRate = TotalRate.calculatingOf(lottoResults).getBenefit()

        // then
        assertThat(totalRate).isEqualByComparingTo(expectedTotalRate)
    }

    companion object {
        @JvmStatic
        fun generateWinningNumbers(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 601.0.toBigDecimal()),
                Arguments.of(listOf(1, 2, 6, 8, 5, 10), 30.00.toBigDecimal()),
                Arguments.of(listOf(10, 14, 18, 20, 13, 21), 0.00.toBigDecimal()),
                Arguments.of(listOf(10, 14, 17, 20, 13, 24), 1.00.toBigDecimal())
            )
        }
    }
}
