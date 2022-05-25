package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class StatisticsTest {

    companion object {
        @JvmStatic
        private fun statisticsData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(Lotto(listOf(1, 2, 3, 4, 5, 6))),
                    10000,
                    200000.00,
                    listOf(
                        StatisticsItem(standardPrize = 5000, prize = LottoResult.Prize.THIRD, machLottoCount = 0),
                        StatisticsItem(standardPrize = 50000, prize = LottoResult.Prize.FORTH, machLottoCount = 0),
                        StatisticsItem(standardPrize = 1500000, prize = LottoResult.Prize.FIFTH, machLottoCount = 0),
                        StatisticsItem(standardPrize = 2000000000, prize = LottoResult.Prize.SIXTH, machLottoCount = 1),
                    )
                ),
                Arguments.of(
                    listOf(Lotto(listOf(1, 2, 3, 7, 8, 9)), Lotto(listOf(4, 5, 6, 10, 11, 12))),
                    10000,
                    1.00,
                    listOf(
                        StatisticsItem(standardPrize = 5000, prize = LottoResult.Prize.THIRD, machLottoCount = 2),
                        StatisticsItem(standardPrize = 50000, prize = LottoResult.Prize.FORTH, machLottoCount = 0),
                        StatisticsItem(standardPrize = 1500000, prize = LottoResult.Prize.FIFTH, machLottoCount = 0),
                        StatisticsItem(standardPrize = 2000000000, prize = LottoResult.Prize.SIXTH, machLottoCount = 0),
                    )
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("statisticsData")
    fun `로또 통계 결과 확인`(lottoList: List<Lotto>, purchasePrice: Int, expectedEarnings: Double, expectedList: List<StatisticsItem>) {
        val stat = Statistics(lottoList.map { LottoResult(lotto = it, winningValue = "1,2,3,4,5,6") }, purchasePrice).apply {
            this.run()
        }

        assertThat(stat.totalEarnings).isEqualTo(expectedEarnings)
        assertThat(stat.items).isEqualTo(expectedList)

    }
}
