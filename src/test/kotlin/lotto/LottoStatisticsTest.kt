package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal
import java.util.stream.Stream

class LottoStatisticsTest {
    @Test
    fun `특정 등수의 개수를 반환한다`() {
        val ranks = Ranks(mapOf(Rank.FIRST to 2, Rank.SECOND to 1, Rank.THIRD to 3))
        val amount = Amount(5000)
        val statistics = LottoStatistics(ranks, amount)

        val actual = statistics.machRankCount(Rank.SECOND)

        assertThat(actual).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "FIRST, 1000000, 2000.00",
            "SECOND, 1000000, 30.00",
            "THIRD, 1000000, 1.50",
            "FOURTH, 10000, 5.00",
            "FIFTH, 3000, 1.66",
            "MISS, 3000, 0.00",
        ],
        delimiter = ',',
    )
    fun `수익률을 계산한다`(
        rank: Rank,
        initAmount: Int,
        expectedRate: BigDecimal,
    ) {
        val ranks = Ranks(mapOf(rank to 1))
        val amount = Amount(initAmount)
        val statistics = LottoStatistics(ranks, amount)

        val rate = statistics.rate()

        assertThat(rate).isEqualTo(expectedRate)
    }

    @Test
    fun `손실인지 여부를 반환한다`() {
        val ranks = Ranks(mapOf(Rank.FIRST to 1))
        val amount = Amount(5000)
        val statistics = LottoStatistics(ranks, amount)

        val isLoss = statistics.isLoss()

        assertThat(isLoss).isFalse()
    }


    @ParameterizedTest
    @MethodSource("rankTestData")
    fun `등수 별로 일치갯수를 알 수 있다`(
        winningNumbers: Lotto,
        userLottos: Lottos,
        bonusNumber: Int,
        expectedRank: Rank,
    ) {
        val user = User(Amount(1000))
        user.buyLotto { userLottos }

        val actual = LottoStatistics.from(user, winningNumbers, LottoNumber(bonusNumber))

        assertThat(actual.machRankCount(expectedRank)).isEqualTo(1)
    }

    companion object {
        @JvmStatic
        fun rankTestData(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lottos(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))),
                    7,
                    Rank.FIRST,
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 10)),
                    Lottos(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))),
                    10,
                    Rank.SECOND,
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 10)),
                    Lottos(listOf(Lotto(listOf(1, 2, 3, 4, 5, 20)))),
                    45,
                    Rank.THIRD,
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 11, 13)),
                    Lottos(listOf(Lotto(listOf(1, 2, 3, 4, 20, 30)))),
                    5,
                    Rank.FOURTH,
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 10, 11, 12)),
                    Lottos(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))),
                    5,
                    Rank.FIFTH,
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lottos(listOf(Lotto(listOf(1, 2, 10, 11, 12, 13)))),
                    5,
                    Rank.MISS,
                ),
            )
    }
}
