package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ProfitTest {

    @Test
    fun `당첨된 로또가 없으면 수익률은 0이다`() {
        val prizeRankCount = mapOf(LottoPrize.WHACK to PositiveNumber(1))
        val purchaseAmount = Money(1000)
        val profit = Profit(prizeRankCount = prizeRankCount, purchaseAmount = purchaseAmount)

        val result = profit.rate()

        assertThat(result).isEqualTo(0.0)
    }

    @ParameterizedTest
    @MethodSource("providePrizeRankCountAndPurchaseAmount")
    fun `수익률은 총 당첨금에서 구매한 금액을 나눈 값이다`(
        prizeRankCount: Map<LottoPrize, PositiveNumber>,
        purchaseAmount: Money,
        expected: Double
    ) {
        val profit = Profit(prizeRankCount = prizeRankCount, purchaseAmount = purchaseAmount)
        val result = profit.rate()
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("providePrimeProfit")
    fun `수익률은 소수점 7자리에서 반올림한다`(
        prizeRankCount: Map<LottoPrize, PositiveNumber>,
        purchaseAmount: Money,
        expected: Double
    ) {
        val profit = Profit(prizeRankCount = prizeRankCount, purchaseAmount = purchaseAmount)
        val result = profit.rate()
        assertThat(result).isEqualTo(expected)
    }

    companion object {

        @JvmStatic
        private fun providePrizeRankCountAndPurchaseAmount(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    mapOf(
                        LottoPrize.FIRST_PRIZE to PositiveNumber(1),
                        LottoPrize.SECOND_PRIZE to PositiveNumber(1)
                    ),
                    Money(1000),
                    2030000.0
                ),
                Arguments.of(
                    mapOf(
                        LottoPrize.FOURTH_PRIZE to PositiveNumber(2)
                    ),
                    Money(2000),
                    50.0
                ),
                Arguments.of(
                    mapOf(
                        LottoPrize.FOURTH_PRIZE to PositiveNumber(1)
                    ),
                    Money(20000),
                    2.5
                )
            )
        }

        @JvmStatic
        private fun providePrimeProfit(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    mapOf(
                        LottoPrize.FOURTH_PRIZE to PositiveNumber(2)
                    ),
                    Money(3000),
                    33.333333
                ),
                Arguments.of(
                    mapOf(
                        LottoPrize.FOURTH_PRIZE to PositiveNumber(2)
                    ),
                    Money(1500),
                    66.666667
                )
            )
        }
    }
}
