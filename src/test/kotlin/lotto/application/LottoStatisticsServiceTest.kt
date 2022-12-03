package lotto.application

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto

class LottoStatisticsServiceTest : FreeSpec({

    val luckyNumber = listOf(1, 2, 3, 4, 5, 6)
    val lottoList = listOf(
        Lotto(listOf(1, 2, 3, 4, 5, 6)),
        Lotto(listOf(10, 11, 12, 13, 14, 15))
    )

    "statistics" - {

        "수익률과 당첨 상금을 반환한다." {
            val lottoStatisticsService = LottoStatisticsService()

            val statistics = lottoStatisticsService.statistics(luckyNumber, lottoList, 2000)

            statistics.totalRate shouldBe 1000000.0
        }
    }
})
