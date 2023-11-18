package lotto2.application

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.shouldBe
import lotto2.application.LottoResultAnalyticsApplication.getProfitRate
import lotto2.application.LottoResultAnalyticsApplication.getWinningStatistics
import lotto2.domain.LottoRanking

class `당첨 통계 테스트` : StringSpec({

    "당첨이 한번도 안된 등수는 0으로 반환한다." {
        val 당첨등수_집합 = mapOf(
            LottoRanking.FIRST to 1,
            LottoRanking.THIRD to 3
        )
        val result = getWinningStatistics(당첨등수_집합)

        result.size shouldBe 6
        result[LottoRanking.FIRST] shouldBe 1
        result[LottoRanking.SECOND] shouldBe 0
        result[LottoRanking.THIRD] shouldBe 3
        result[LottoRanking.FOURTH] shouldBe 0
        result[LottoRanking.FIFTH] shouldBe 0
        result[LottoRanking.MISS] shouldBe 0
    }

    "비어 있는 등수 집합일 경우 모든 등수를 0으로 반환한다." {
        val 당첨등수_집합 = emptyMap<LottoRanking, Int>()
        val result = getWinningStatistics(당첨등수_집합)

        result.size shouldBe 6
        LottoRanking.values().forEach {
            result[it] shouldBe 0
        }
    }
})

class `수익률 계산 테스트` : StringSpec({

    "만원을 투자해 1등 한번과 4등 3번을 했을 경우, 수익률은 200015.0이 반환된다." {
        val 당첨등수_집합 = mapOf(
            LottoRanking.FIRST to 1, // 2,000,000,000
            LottoRanking.FOURTH to 3 // 3 * 50,000 = 150,000
        )
        val 투자금액 = 10_000 // 10,000원 투자
        val 수익률 = getProfitRate(당첨등수_집합, 투자금액)

        // 예상 수익률 = (2,000,150,000 / 10,000) = 200015
        수익률 shouldBeExactly 200015.0
    }

    "만원을 투자해 5등 한번을 했을 경우, 수익률은 0.5가 반환된다." {
        val 당첨등수_집합 = mapOf(
            LottoRanking.FIFTH to 1, // 5,000
        )
        val 투자금액 = 10_000 // 10,000원 투자

        val 수익률 = getProfitRate(당첨등수_집합, 투자금액)

        // 예상 수익률 = (5,000 / 10,000) = 0.5
        수익률 shouldBeExactly 0.5
    }

    "당첨이 한번도 되지 않았으면 수익률은 0.0이 반환된다" {
        val 당첨등수_집합 = mapOf(
            LottoRanking.MISS to 1,
        )
        val 투자금액 = 1000

        val 수익률 = getProfitRate(당첨등수_집합, 투자금액)

        수익률 shouldBeExactly 0.0
    }
})
