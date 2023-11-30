package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.Row2
import io.kotest.data.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.Earning
import lotto.domain.MatchCount

class EarningTest : StringSpec({

    "정답 결과에 따라서 알맞은 수익이 발생해야한다" {
        val earning = Earning(
            mapOf(
                MatchCount.THREE to 5000,
                MatchCount.FOUR to 50000,
                MatchCount.FIVE to 1500000,
                MatchCount.FIVE_WITH_BONUS to 30000000,
                MatchCount.SIX to 2000000000
            )
        )
        forAll(
            Row2(mapOf(MatchCount.THREE to 1), 5000),
            Row2(mapOf(MatchCount.THREE to 1, MatchCount.FOUR to 2), 105000)
        ) { lottoResult, actual ->
            val result = earning.calculate(lottoResult)
            result shouldBe actual
        }
    }
})
