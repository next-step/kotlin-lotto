package lotto

import lotto.domain.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoReturnCalculatorTest {

    @ParameterizedTest
    @MethodSource("로또 1, 2, 3, 4, 5등 테스트 데이터")
    fun `로또 1, 2, 3, 4, 5등 검출 테스트`(
        lottoList: List<LottoNumbers>,
        winningNumbers: LottoWinningNumbers,
        lottoReturn: LottoReturn
    ) {
        Assertions.assertThat(
            LottoReturnCalculator(lottoList).calculate(winningNumbers)
        ).isEqualTo(lottoReturn)
    }

    @ParameterizedTest
    @MethodSource("로또 여러개 당첨 테스트 데이터")
    fun `로또 여러개 당첨 검출 테스트`(
        lottoList: List<LottoNumbers>,
        winningNumbers: LottoWinningNumbers,
        lottoReturn: LottoReturn
    ) {
        Assertions.assertThat(
            LottoReturnCalculator(lottoList).calculate(winningNumbers)
        ).isEqualTo(lottoReturn)
    }

    @ParameterizedTest
    @MethodSource("로또 여러개 당첨 수익률 테스트 데이터")
    fun `로또 수익률 계산 테스트`(lottoList: List<LottoNumbers>, winningNumbers: LottoWinningNumbers, returnRatio: Float) {
        Assertions.assertThat(
            LottoReturnCalculator(lottoList).calculate(winningNumbers)
                .returnRatio
        ).isEqualTo(returnRatio)
    }

    companion object {

        @JvmStatic
        fun `로또 1, 2, 3, 4, 5등 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                `로또 1등 테스트 데이터`(),
                `로또 2등 테스트 데이터`(),
                `로또 3등 테스트 데이터`(),
                `로또 4등 테스트 데이터`(),
                `로또 5등 테스트 데이터`(),
            ).flatMap { it }
        }

        @JvmStatic
        fun `로또 1등 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)),
                    ),
                    LottoWinningNumbers(LottoNumbers(setOf(1, 2, 3, 4, 5, 6)), 7),
                    LottoReturn(
                        firstCount = 1,
                        secondCount = 0,
                        thirdCount = 0,
                        fourthCount = 0,
                        fifthCount = 0,
                        paidAmount = LottoVendingMachine.LOTTO_PRICE,
                    )
                )
            )
        }

        @JvmStatic
        fun `로또 2등 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)),
                    ),
                    LottoWinningNumbers(LottoNumbers(setOf(11, 2, 3, 4, 5, 6)), 1),
                    LottoReturn(
                        firstCount = 0,
                        secondCount = 1,
                        thirdCount = 0,
                        fourthCount = 0,
                        fifthCount = 0,
                        paidAmount = LottoVendingMachine.LOTTO_PRICE,
                    )
                )
            )
        }

        @JvmStatic
        fun `로또 3등 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)),
                    ),
                    LottoWinningNumbers(LottoNumbers(setOf(11, 2, 3, 4, 5, 6)), 7),
                    LottoReturn(
                        firstCount = 0,
                        secondCount = 0,
                        thirdCount = 1,
                        fourthCount = 0,
                        fifthCount = 0,
                        paidAmount = LottoVendingMachine.LOTTO_PRICE,
                    )
                )
            )
        }

        @JvmStatic
        fun `로또 4등 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)),
                    ),
                    LottoWinningNumbers(LottoNumbers(setOf(11, 12, 3, 4, 5, 6)), 7),
                    LottoReturn(
                        firstCount = 0,
                        secondCount = 0,
                        thirdCount = 0,
                        fourthCount = 1,
                        fifthCount = 0,
                        paidAmount = LottoVendingMachine.LOTTO_PRICE,
                    )
                )
            )
        }

        @JvmStatic
        fun `로또 5등 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)),
                    ),
                    LottoWinningNumbers(LottoNumbers(setOf(11, 12, 13, 4, 5, 6)), 7),
                    LottoReturn(
                        firstCount = 0,
                        secondCount = 0,
                        thirdCount = 0,
                        fourthCount = 0,
                        fifthCount = 1,
                        paidAmount = LottoVendingMachine.LOTTO_PRICE,
                    )
                )
            )
        }

        @JvmStatic
        fun `로또 여러개 당첨 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)),
                        LottoNumbers(setOf(2, 3, 4, 5, 6, 7)),
                        LottoNumbers(setOf(11, 2, 3, 4, 5, 6)),
                    ),
                    LottoWinningNumbers(LottoNumbers(setOf(1, 2, 3, 4, 5, 6)), 7),
                    LottoReturn(
                        firstCount = 1,
                        secondCount = 1,
                        thirdCount = 1,
                        fourthCount = 0,
                        fifthCount = 0,
                        paidAmount = LottoVendingMachine.LOTTO_PRICE * 3,
                    )
                )
            )
        }

        @JvmStatic
        fun `로또 여러개 당첨 수익률 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)),
                        LottoNumbers(setOf(11, 2, 3, 4, 5, 6)),
                    ),
                    LottoWinningNumbers(LottoNumbers(setOf(1, 2, 3, 4, 5, 6)), 7),
                    (LottoReturn.FIRST_RETURN + LottoReturn.THIRD_RETURN) / (LottoVendingMachine.LOTTO_PRICE * 2.toFloat())
                ),
                Arguments.of(
                    listOf(
                        LottoNumbers(setOf(2, 3, 4, 5, 6, 7)),
                        LottoNumbers(setOf(11, 2, 3, 4, 5, 6)),
                    ),
                    LottoWinningNumbers(LottoNumbers(setOf(1, 2, 3, 4, 5, 6)), 7),
                    (LottoReturn.SECOND_RETURN + LottoReturn.THIRD_RETURN) / (LottoVendingMachine.LOTTO_PRICE * 2.toFloat())
                ),
                Arguments.of(
                    listOf(
                        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)),
                    ),
                    LottoWinningNumbers(LottoNumbers(setOf(11, 12, 3, 4, 5, 6)), 7),
                    LottoReturn.FOURTH_RETURN / LottoVendingMachine.LOTTO_PRICE.toFloat()
                )
            )
        }
    }
}
