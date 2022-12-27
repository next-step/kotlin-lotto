package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoStatisticsTest : StringSpec({
    "로또 수익률 계산 테스트" {
        forAll(
            row(listOf(LottoRank.FOURTH, LottoRank.FIFTH), Payment(100000), 0.55),
            row(listOf(LottoRank.FIFTH), Payment(5000), 1.0),
            row(listOf(LottoRank.FOURTH), Payment(5000), 10.0),
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
            LottoStatisticsResult(LottoRank.FIFTH, 3),
            LottoStatisticsResult(LottoRank.FOURTH, 0),
            LottoStatisticsResult(LottoRank.THIRD, 2),
            LottoStatisticsResult(LottoRank.SECOND, 0),
            LottoStatisticsResult(LottoRank.FIRST, 1),
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
