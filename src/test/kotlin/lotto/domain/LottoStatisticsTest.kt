package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.common.DoubleNumber
import lotto.common.IntegerNumber

class LottoStatisticsTest : StringSpec({
    "로또 수익률 계산 테스트" {
        forAll(
            row(listOf(LottoRank.FOURTH, LottoRank.FIFTH), Payment(IntegerNumber(100000)), DoubleNumber(0.55)),
            row(listOf(LottoRank.FIFTH), Payment(IntegerNumber(5000)), DoubleNumber(1.0)),
            row(listOf(LottoRank.FOURTH), Payment(IntegerNumber(5000)), DoubleNumber(10.0)),
        ) { prizeList, payment, expectedEarningRate ->
            // given
            val lottoStatistics = LottoStatistics(prizeList)
            // when
            val actualEarningRate = lottoStatistics.earningRate(payment)
            // then
            actualEarningRate shouldBe expectedEarningRate
        }
    }

    "로또 당첨 통계 테스트" {
        // given
        val winLottoList = listOf(
            LottoRank.FIRST,
            LottoRank.THIRD,
            LottoRank.THIRD,
            LottoRank.FIFTH,
            LottoRank.FIFTH,
            LottoRank.FIFTH,
        )
        val lottoStatistics = LottoStatistics(winLottoList)

        val expected = listOf(
            LottoStatisticsResult(LottoRank.FIFTH, IntegerNumber(3)),
            LottoStatisticsResult(LottoRank.FOURTH, IntegerNumber(0)),
            LottoStatisticsResult(LottoRank.THIRD, IntegerNumber(2)),
            LottoStatisticsResult(LottoRank.SECOND, IntegerNumber(0)),
            LottoStatisticsResult(LottoRank.FIRST, IntegerNumber(1)),
        )

        // when
        val actual = lottoStatistics.winLottoStatistics()

        // then
        actual.size shouldBe expected.size
        actual.forEachIndexed { index, result ->
            result.winLottoCount shouldBe expected[index].winLottoCount
            result.lottoRank shouldBe expected[index].lottoRank
        }
    }
})
