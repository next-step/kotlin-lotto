package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.application.common.Number
import lotto.domain.LottoRank
import lotto.domain.LottoStatistics
import lotto.domain.LottoStatisticsResult
import lotto.domain.Payment

class LottoStatisticsTest : StringSpec({
    "로또 수익률 계산 테스트" {
        forAll(
            row(listOf(LottoRank.FOURTH, LottoRank.FIFTH), Payment(Number(100000)), 0.55),
            row(listOf(LottoRank.FIFTH), Payment(Number(5000)), 1.0),
            row(listOf(LottoRank.FOURTH), Payment(Number(5000)), 10),
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
            LottoStatisticsResult(LottoRank.FIFTH, Number(3)),
            LottoStatisticsResult(LottoRank.FOURTH, Number(0)),
            LottoStatisticsResult(LottoRank.THIRD, Number(2)),
            LottoStatisticsResult(LottoRank.SECOND, Number(0)),
            LottoStatisticsResult(LottoRank.FIRST, Number(1)),
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
