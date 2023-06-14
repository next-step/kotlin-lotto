package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PrizeStaticsTest : StringSpec({
    "각 등수의 갯수를 저장한다" {
        val prizeStatics = PrizeStatics(
            mapOf(
                WinnerPrize.FIRST_PRIZE to 1,
                WinnerPrize.SECOND_PRIZE to 1,
                WinnerPrize.THIRD_PRIZE to 2,
                WinnerPrize.FOURTH_PRIZE to 2,
                WinnerPrize.NOTHING to 1
            )
        )

        prizeStatics[WinnerPrize.FIRST_PRIZE] shouldBe 1
        prizeStatics[WinnerPrize.SECOND_PRIZE] shouldBe 1
        prizeStatics[WinnerPrize.THIRD_PRIZE] shouldBe 2
        prizeStatics[WinnerPrize.FOURTH_PRIZE] shouldBe 2
        prizeStatics[WinnerPrize.NOTHING] shouldBe 1
    }

    "상금의 총합을 구한다" {
        // given
        val prizeStatics = PrizeStatics(
            mapOf(
                WinnerPrize.FIRST_PRIZE to 1,
                WinnerPrize.SECOND_PRIZE to 1,
                WinnerPrize.THIRD_PRIZE to 2,
                WinnerPrize.FOURTH_PRIZE to 2,
                WinnerPrize.NOTHING to 1
            )
        )

        // when
        prizeStatics.getPrizeMoneyTotal() shouldBe Money(2_001_610_000)
    }
})
