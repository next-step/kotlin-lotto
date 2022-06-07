package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.bigdecimal.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import lotto.domain.LottoResult
import lotto.domain.LottoStatistics
import lotto.domain.Money
import lotto.domain.Winning

class LottoStatisticsTest : FreeSpec({
    "구매금액과 당첨금액을 이용해 수익률을 계산할 수 있다" {
        val money = Money(3_000)
        val lottoResult = LottoResult(
            mapOf(
                Winning.FIFTH_PLACE to 2,
                Winning.FOURTH_PLACE to 1,
            )
        )

        val statistics = LottoStatistics(money, lottoResult)

        val expectedTotal = 60_000
        val expectedYield = 1

        statistics.getTotalAmount() shouldBe expectedTotal.toBigDecimal()
        statistics.getYield() shouldBeGreaterThan expectedYield.toBigDecimal()
    }
})
