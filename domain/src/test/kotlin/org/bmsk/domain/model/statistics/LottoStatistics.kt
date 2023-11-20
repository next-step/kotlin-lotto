package org.bmsk.domain.model.statistics

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.bmsk.domain.model.lotto.LottoLottery

class LottoStatisticsTest : FunSpec({
    context("LottoStatisticsAnalyzer") {
        val mockLottoLotteries = listOf(
            LottoLottery(listOf(8, 21, 23, 41, 42, 43)),
            LottoLottery(listOf(3, 5, 11, 16, 32, 38)),
            LottoLottery(listOf(7, 11, 16, 35, 36, 44)),
            LottoLottery(listOf(1, 8, 11, 31, 41, 42)),
            LottoLottery(listOf(13, 14, 16, 38, 42, 45)),
            LottoLottery(listOf(7, 11, 30, 40, 42, 43)),
            LottoLottery(listOf(2, 13, 22, 32, 38, 45)),
            LottoLottery(listOf(23, 25, 33, 36, 39, 41)),
            LottoLottery(listOf(1, 3, 5, 14, 22, 45)),
            LottoLottery(listOf(5, 9, 38, 41, 43, 44)),
            LottoLottery(listOf(2, 8, 9, 18, 19, 21)),
            LottoLottery(listOf(13, 14, 18, 21, 23, 35)),
            LottoLottery(listOf(17, 21, 29, 37, 42, 45)),
            LottoLottery(listOf(3, 8, 27, 30, 35, 44)),
        )
        val analyzer = LottoStatisticsAnalyzer(mockLottoLotteries)

        test("주어진 임의 데이터에 대해 당첨 번호가 1, 2, 3, 4, 5, 6이라면 총 수익률은 0.35이다.") {
            val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val stats = analyzer.calculateLottoStatistics(winningNumbers)

            stats.numberOfMatches3 shouldBe 1
            stats.numberOfMatches4 shouldBe 0
            stats.numberOfMatches5 shouldBe 0
            stats.numberOfMatches6 shouldBe 0
            (stats.totalProfitRate * 100).toInt() / 100.0 shouldBe 0.35
        }
    }
})
