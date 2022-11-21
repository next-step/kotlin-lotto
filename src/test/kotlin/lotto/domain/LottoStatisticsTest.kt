package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe

class LottoStatisticsTest : StringSpec({
    "수익률 테스트 " {
        val payment = 15000
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoResult = LottoResult(lotto, 3, 5000)

        val expectedResult = 0.33

        val actualResult = LottoStatistics.statistics(payment, listOf(lottoResult))
        actualResult.earningRate shouldBe expectedResult
    }

    "당첨자 통계 결과 테스트" {
        val payment = 15000
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        forAll(
            row(
                LottoResult(lotto, 2, 0),
                listOf(
                    LottoStatisticsResult(3, 5000, 0),
                    LottoStatisticsResult(4, 50000, 0),
                    LottoStatisticsResult(5, 1500000, 0),
                    LottoStatisticsResult(6, 2000000000, 0),
                )
            ),
            row(
                LottoResult(lotto, 3, 5000),
                listOf(
                    LottoStatisticsResult(3, 5000, 1),
                    LottoStatisticsResult(4, 50000, 0),
                    LottoStatisticsResult(5, 1500000, 0),
                    LottoStatisticsResult(6, 2000000000, 0),
                )
            ),
            row(
                LottoResult(lotto, 6, 2000000000),
                listOf(
                    LottoStatisticsResult(3, 5000, 0),
                    LottoStatisticsResult(4, 50000, 0),
                    LottoStatisticsResult(5, 1500000, 0),
                    LottoStatisticsResult(6, 2000000000, 1),
                )
            )
        ) { lottoResult, expected ->
            val result = LottoStatistics.statistics(payment, listOf(lottoResult))
            val actualWinLottoStatisticsResult = result.winLottoStatisticsResult

            actualWinLottoStatisticsResult.size shouldBe expected.size

            actualWinLottoStatisticsResult.forEachIndexed { index, lottoStatisticsResult ->
                lottoStatisticsResult shouldBeEqualToComparingFields expected[index]
            }
        }
    }
})
