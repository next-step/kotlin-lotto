package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : StringSpec({
    "LottoResult should provide correct profit rate" {
        LottoResult(
            LottoProfitResult(
                totalTicketPrice = 5_000,
                totalPrize = 4_600_000,
                remainder = 0
            )
        ).profitRate shouldBe 920
    }
})
