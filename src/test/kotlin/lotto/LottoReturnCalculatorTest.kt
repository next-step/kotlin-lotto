package lotto

import lotto.domain.LottoNumbers
import lotto.domain.LottoReturn
import lotto.domain.LottoReturnCalculator
import lotto.domain.LottoVendingMachine
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoReturnCalculatorTest {

    @ParameterizedTest
    @MethodSource("로또 1, 2, 3, 4등 테스트 데이터")
    fun `로또 1, 2, 3, 4등 검출 테스트`(lottoList: List<LottoNumbers>, winningNumbers: LottoNumbers, lottoReturn: LottoReturn) {
        Assertions.assertThat(
            LottoReturnCalculator(lottoList).calculate(winningNumbers)
        ).isEqualTo(lottoReturn)
    }

    @ParameterizedTest
    @MethodSource("로또 여러개 당첨 테스트 데이터")
    fun `로또 여러개 당첨 검출 테스트`(lottoList: List<LottoNumbers>, winningNumbers: LottoNumbers, lottoReturn: LottoReturn) {
        Assertions.assertThat(
            LottoReturnCalculator(lottoList).calculate(winningNumbers)
        ).isEqualTo(lottoReturn)
    }

    @ParameterizedTest
    @MethodSource("로또 여러개 당첨 수익률 테스트 데이터")
    fun `로또 수익률 계산 테스트`(lottoList: List<LottoNumbers>, winningNumbers: LottoNumbers, returnRatio: Float) {
        Assertions.assertThat(
            LottoReturnCalculator(lottoList).calculate(winningNumbers)
                .returnRatio
        ).isEqualTo(returnRatio)
    }

    companion object {

        @JvmStatic
        fun `로또 1, 2, 3, 4등 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                `로또 1등 테스트 데이터`(),
                `로또 2등 테스트 데이터`(),
                `로또 3등 테스트 데이터`(),
                `로또 4등 테스트 데이터`()
            ).flatMap { it }
        }

        @JvmStatic
        fun `로또 1등 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                    ),
                    LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                    LottoReturn(
                        firstCount = 1,
                        secondCount = 0,
                        thirdCount = 0,
                        fourthCount = 0,
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
                        LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                    ),
                    LottoNumbers(listOf(11, 2, 3, 4, 5, 6)),
                    LottoReturn(
                        firstCount = 0,
                        secondCount = 1,
                        thirdCount = 0,
                        fourthCount = 0,
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
                        LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                    ),
                    LottoNumbers(listOf(11, 12, 3, 4, 5, 6)),
                    LottoReturn(
                        firstCount = 0,
                        secondCount = 0,
                        thirdCount = 1,
                        fourthCount = 0,
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
                        LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                    ),
                    LottoNumbers(listOf(11, 12, 13, 4, 5, 6)),
                    LottoReturn(
                        firstCount = 0,
                        secondCount = 0,
                        thirdCount = 0,
                        fourthCount = 1,
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
                        LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                        LottoNumbers(listOf(11, 2, 3, 4, 5, 6)),
                    ),
                    LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                    LottoReturn(
                        firstCount = 1,
                        secondCount = 1,
                        thirdCount = 0,
                        fourthCount = 0,
                        paidAmount = LottoVendingMachine.LOTTO_PRICE * 2,
                    )
                )
            )
        }

        @JvmStatic
        fun `로또 여러개 당첨 수익률 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                        LottoNumbers(listOf(11, 2, 3, 4, 5, 6)),
                    ),
                    LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                    (LottoReturn.FIRST_RETURN + LottoReturn.SECOND_RETURN) / (LottoVendingMachine.LOTTO_PRICE * 2.toFloat())
                ),
                Arguments.of(
                    listOf(
                        LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                    ),
                    LottoNumbers(listOf(11, 12, 3, 4, 5, 6)),
                    LottoReturn.THIRD_RETURN / LottoVendingMachine.LOTTO_PRICE.toFloat()
                )
            )
        }
    }
}
