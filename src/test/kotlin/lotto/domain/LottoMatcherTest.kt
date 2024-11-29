package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoMatcherTest : StringSpec({
    "should match tickets with the correct winning category" {
        val winningNumbers = Lotto.of(listOf(1, 2, 3, 4, 5, 6))

        val matcher = LottoMatcher(winningNumbers)

        val ticket1 = Lotto.of(listOf(1, 2, 3, 7, 8, 9))
        val ticket2 = Lotto.of(listOf(1, 2, 3, 4, 8, 9))
        val ticket3 = Lotto.of(listOf(1, 2, 3, 4, 5, 9))
        val ticket4 = Lotto.of(listOf(1, 2, 3, 4, 5, 6))

        matcher.match(ticket1) shouldBe WinningCategory.FOURTH
        matcher.match(ticket2) shouldBe WinningCategory.THIRD
        matcher.match(ticket3) shouldBe WinningCategory.SECOND
        matcher.match(ticket4) shouldBe WinningCategory.FIRST
    }
})
