package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoStatistics
import lotto.domain.Rank
import lotto.domain.WinningResult

class WinningResultTest : StringSpec({
    "수익을 제공한다." {
        val result = WinningResult.from(listOf(LottoStatistics(1, Rank.FIFTH)), 1000)

        result.revenue shouldBe Rank.FIFTH.prizeAmount
    }

    "수익률을 제공한다." {
        val result = WinningResult.from(listOf(LottoStatistics(1, Rank.FIRST)), 1000)

        result.rate shouldBe 2000000.0
    }
})
