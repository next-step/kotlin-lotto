package lotto.domain

import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.maps.shouldNotHaveKey
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal
import java.util.stream.Stream

internal class LotteryMachineTest {

    @DisplayName("구입 금액에 해당하는 로또를 발급한다")
    @Test
    fun buyLottery() {
        listOf(
            1000 to 1,
            1500 to 1,
            3900 to 3,
            10000 to 10
        ).map { (payAmount, howManyBought) ->
            {
                val result = LotteryMachine.buyLotteries(payAmount)

                result.count() shouldBe howManyBought
            }
        }
    }

    @Test
    fun getMatchResult() {

        val result = LotteryMachine.getMatchCount(
            Lotteries(
                Lottery(1, 2, 13, 14, 15, 16),
                Lottery(11, 12, 13, 4, 5, 6),
                Lottery(1, 2, 3, 14, 15, 16)
            ),
            Lottery(1, 2, 3, 4, 5, 6)
        )
        assertAll(
            { result.matchCount[2] shouldBe 1 },
            { result.matchCount[3] shouldBe 2 },
            { listOf(0, 1, 4, 5).forEach { result.matchCount shouldNotHaveKey it } }
        )
    }

    @DisplayName("수익률을 구한다 (소숫점 2자리수에서 반올림한다)")
    @ParameterizedTest
    @MethodSource("calculateReturnRateProvider")
    fun calculateReturnRate(payAmount: Int, countSameLottoNumber: Map<Int, Int>, expected: BigDecimal) {

        LotteryMachine.calculateReturnRate(
            payAmount,
            LotteryMatchCount(countSameLottoNumber)
        ) shouldBeEqualComparingTo expected
    }

    companion object {
        @JvmStatic
        fun calculateReturnRateProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(14000, mapOf(3 to 1, 2 to 1), BigDecimal.valueOf(0.35)),
            Arguments.of(10000, mapOf(1 to 3), BigDecimal.ZERO),
            Arguments.of(30000, mapOf(4 to 1, 3 to 1, 2 to 1), BigDecimal.valueOf(1.83)),
            Arguments.of(20000, mapOf(5 to 1, 4 to 1), BigDecimal.valueOf(77.5))
        )
    }
}
