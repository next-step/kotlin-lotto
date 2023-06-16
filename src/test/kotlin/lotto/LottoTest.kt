package lotto

import lotto.domain.BillSlot
import lotto.domain.LottoNumbers
import lotto.domain.LottoReturn
import lotto.domain.LottoReturnCalculator
import lotto.domain.LottoVendingMachine
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoTest {
    @ParameterizedTest
    @CsvSource(
        "14000, 1000, 14",
        "1300, 1000, 1",
        "1000, 2000, 0",
    )
    fun `주어진 금액으로 구입할 수 있는 로또 개수 구하기 테스트`(money: Int, lottoPrice: Int, numOfLotto: Int) {
        val billSlot = BillSlot(lottoPrice = lottoPrice)
        assertThat(billSlot.insertMoney(money))
            .isEqualTo(numOfLotto)
    }

    @Test
    fun `발급된 로또 번호는 6개여야 한다`() {
        assertThat(
            LottoNumbers.generate()
                .numbers
                .size
        ).isEqualTo(6)
    }

    @ParameterizedTest
    @CsvSource(
        "14000, 1000, 14",
        "1300, 1000, 1",
        "1000, 2000, 0",
    )
    fun `금액에 맞는 개수 만큼 로또 번호를 생성해야 한다`(money: Int, lottoPrice: Int, numOfLotto: Int) {
        assertThat(
            LottoVendingMachine(BillSlot(lottoPrice))
                .purchase(money)
                .size
        ).isEqualTo(numOfLotto)
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있다면 throw IllegalArgumentException`() {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers(listOf(1, 1, 2, 3, 4, 5))
        }
    }

    @ParameterizedTest
    @MethodSource("범위를 벗어난 숫자가 있는 로또 번호")
    fun `로또 번호에 범위를 벗어난 숫자가 있다면 throw IllegalArgumentException`(lottoNumbers: List<Int>) {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers(lottoNumbers)
        }
    }

    @ParameterizedTest
    @MethodSource("숫자가 6개가 아닌 로또 번호")
    fun `로또 번호가 6개가 아니라면 throw IllegalStateException`(lottoNumbers: List<Int>) {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers(lottoNumbers)
        }
    }

    @ParameterizedTest
    @MethodSource("겹치는 로또 번호 테스트 데이터")
    fun `겹치는 로또 번호 개수 구하기 테스트`(lottoNumbers1: List<Int>, lottoNumbers2: List<Int>, overlaps: Int) {
        assertThat(
            LottoNumbers(lottoNumbers1).numberOfOverlaps(LottoNumbers(lottoNumbers2))
        ).isEqualTo(overlaps)
    }

    @ParameterizedTest
    @MethodSource("로또 1, 2, 3, 4등 테스트 데이터")
    fun `로또 1, 2, 3, 4등 검출 테스트`(lottoList: List<LottoNumbers>, winningNumbers: LottoNumbers, lottoReturn: LottoReturn) {
        assertThat(
            LottoReturnCalculator(lottoList).calculate(winningNumbers)
        ).isEqualTo(lottoReturn)
    }

    @ParameterizedTest
    @MethodSource("로또 여러개 당첨 테스트 데이터")
    fun `로또 여러개 당첨 검출 테스트`(lottoList: List<LottoNumbers>, winningNumbers: LottoNumbers, lottoReturn: LottoReturn) {
        assertThat(
            LottoReturnCalculator(lottoList).calculate(winningNumbers)
        ).isEqualTo(lottoReturn)
    }

    @ParameterizedTest
    @MethodSource("로또 여러개 당첨 수익률 테스트 데이터")
    fun `로또 수익률 계산 테스트`(lottoList: List<LottoNumbers>, winningNumbers: LottoNumbers, returnRatio: Float) {
        assertThat(
            LottoReturnCalculator(lottoList).calculate(winningNumbers)
                .returnRatio
        ).isEqualTo(returnRatio)
    }

    companion object {
        @JvmStatic
        fun `범위를 벗어난 숫자가 있는 로또 번호`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(-1, 1, 2, 3, 4, 5)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 46)),
            )
        }

        @JvmStatic
        fun `숫자가 6개가 아닌 로또 번호`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7)),
            )
        }

        @JvmStatic
        fun `겹치는 로또 번호 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 12, 13, 14, 15, 16), 1),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(11, 12, 13, 14, 15, 16), 0),
            )
        }

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
