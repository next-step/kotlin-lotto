package lotto.domain.ticket

import lotto.domain.rank.LottoRank
import lotto.domain.rank.LottoRank.FIRST_PLACE
import lotto.domain.rank.LottoRank.FOURTH_PLACE
import lotto.domain.rank.LottoRank.LAST_PLACE
import lotto.domain.rank.LottoRank.SECOND_PLACE
import lotto.domain.rank.LottoRank.THIRD_PLACE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("로또 게임의 결과를 의미하는 객체 `WinningStatistics` 테스트")
internal class WinningStatisticsTest {

    @DisplayName("로또 게임을 구매한 금액과 로또 랭크 목록이 주어지면 `WinningStatistics` 객체 생성")
    @Test
    fun `create WinningStatistics if given LottoGames buy price and LottoRank list`() {
        // Arrange
        // Act
        val winningStatistics = WinningStatistics(lottoGamesBuyPrice = 1_000, lottoGameRanks = listOf(FIRST_PLACE))

        // Assert
        assertThat(winningStatistics.rankMap[FIRST_PLACE]).isEqualTo(1)
    }

    @DisplayName("`WinningStatistics` 객체는 올바른 상금 총액과 수익률을 계산하여 반환")
    @ParameterizedTest
    @MethodSource("lottoGamesBuyPriceAndLottoRanksAndPrizeMoneyAndProfitRate")
    fun `WinningStatistics return correct prizeMoney sum and prize rate`(
        lottoGamesBuyPrice: Int,
        lottoGameRanks: List<LottoRank>,
        expectedPrizeMoneySum: Long,
        expectedProfitRate: Double
    ) {
        // Arrange
        // Act
        val winningStatistics = WinningStatistics(lottoGamesBuyPrice = lottoGamesBuyPrice, lottoGameRanks = lottoGameRanks)

        // Assert
        assertThat(winningStatistics.prizeMoneySum).isEqualTo(expectedPrizeMoneySum)
        assertThat(winningStatistics.profitRate).isEqualTo(expectedProfitRate)
    }

    companion object {
        //    FIRST_PLACE(FIRST_PLACE_MATCHING, 2_000_000_000),
        //    SECOND_PLACE(SECOND_PLACE_MATCHING, 1_500_000),
        //    THIRD_PLACE(THIRD_PLACE_MATCHING, 50_000),
        //    FOURTH_PLACE(FOURTH_PLACE_MATCHING, 5_000),
        //    LAST_PLACE(LAST_PLACE_MATCHING, 0);
        @JvmStatic
        fun lottoGamesBuyPriceAndLottoRanksAndPrizeMoneyAndProfitRate(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    5_000,
                    listOf(FOURTH_PLACE),
                    5_000,
                    1
                ),
                Arguments.of(
                    1_000,
                    listOf(FIRST_PLACE),
                    2_000_000_000,
                    2_000_000
                ),
                Arguments.of(
                    17_000,
                    listOf(THIRD_PLACE, THIRD_PLACE, THIRD_PLACE),
                    150_000,
                    8.823_529_411_764_707
                ),
                Arguments.of(
                    13_000,
                    listOf(FIRST_PLACE, SECOND_PLACE, THIRD_PLACE, FOURTH_PLACE, LAST_PLACE),
                    2_001_555_000,
                    153_965.769_230_769_22
                ),
                Arguments.of(
                    99_000,
                    listOf(FOURTH_PLACE, FOURTH_PLACE, FOURTH_PLACE, FOURTH_PLACE, LAST_PLACE),
                    20_000,
                    0.202_020_202_020_202_02
                ),
                Arguments.of(
                    187_000,
                    listOf(THIRD_PLACE, THIRD_PLACE, FOURTH_PLACE, LAST_PLACE, LAST_PLACE),
                    105_000,
                    0.561_497_326_203_208_6
                ),
            )
    }
}
