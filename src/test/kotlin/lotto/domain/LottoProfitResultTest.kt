package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoProfitResultTest : StringSpec({
    "lotto profit result should calculate correct profit rate" {
        val lottoProfitResult = LottoProfitResult(
            totalTicketPrice = 3_000,
            totalPrize = 5_000,
            remainder = 0
        )

        lottoProfitResult.profitRate shouldBe 1.67
    }
})
