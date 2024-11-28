package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PrizeCalculatorTest : StringSpec({
    "should calculate the prize for the given lotto ticket" {
        val prizeCalculator = PrizeCalculator()

        val statistics =
            mapOf(
                WinningCategory.THREE to 2,
                WinningCategory.FOUR to 1,
                WinningCategory.FIVE to 1,
                WinningCategory.SIX to 1,
            )

        val totalPrize = prizeCalculator.calculateTotalPrize(statistics)
        totalPrize shouldBe (
            WinningCategory.THREE.prize * 2 +
                WinningCategory.FOUR.prize +
                WinningCategory.FIVE.prize +
                WinningCategory.SIX.prize
        )
    }
})
