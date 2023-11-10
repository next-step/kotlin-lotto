package lottoAuto.domain

import lottoAuto.LottoController
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStatsEngineTest {

    @ParameterizedTest
    @CsvSource(
        "14_000, 14",
        "14999, 14",
        "0, 0",
    )
    fun `지불한 로또 구매액에 따라 생성할 로또 개수를 설정한다`(purchaseAmount: Int, expected: Int) {
        // given
        // when
        val numOfLotto = LottoStatsEngine.calcNumOfLotto(purchaseAmount)
        // then
        Assertions.assertEquals(expected, numOfLotto)
    }

    @ParameterizedTest
    @CsvSource(
        "14000, 5_000, 0.35",
        "14999, 5_000, 0.33",
        "0, 5_000, 0.00",
    )
    fun `주어진 로또 구매액과 수익 금액에 따라 수익률을 계산한다`(purchaseAmount: Int, winningMoney: Int, expected: Double) {
        // given
        // when
        val rateOfReturn = LottoStatsEngine.calcRateOfReturn(purchaseAmount, winningMoney)
        // then
        assertEquals(expected, rateOfReturn)
    }

    @Test
    fun `주어진 LottoRank 리스트를 matchCount 필드별로 그룹핑하고 카운트한다`() {
        // given
        val lottoRanks = listOf(
            LottoRank.FIRST,
            LottoRank.SECOND,
            LottoRank.SECOND,
            LottoRank.THIRD,
            LottoRank.THIRD,
            LottoRank.THIRD,
            LottoRank.FOURTH,
            LottoRank.FOURTH,
            LottoRank.FOURTH,
            LottoRank.FOURTH,
        )
        // when
        val groupedLottoRanks = LottoStatsEngine.groupByLottoRank(lottoRanks)

        // then
        assertEquals(1, groupedLottoRanks[LottoRank.FIRST])
        assertEquals(2, groupedLottoRanks[LottoRank.SECOND])
        assertEquals(3, groupedLottoRanks[LottoRank.THIRD])
        assertEquals(4, groupedLottoRanks[LottoRank.FOURTH])
        assertEquals(0, groupedLottoRanks[LottoRank.MISS])
    }

}
