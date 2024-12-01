package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinningCategoryTest : StringSpec({
    "should return SECOND for 5 matches with bonus number" {
        WinningCategory.fromMatchCount(5, true) shouldBe WinningCategory.SECOND
    }

    "should return THIRD for 5 matches without bonus number" {
        WinningCategory.fromMatchCount(5, false) shouldBe WinningCategory.THIRD
    }
})
