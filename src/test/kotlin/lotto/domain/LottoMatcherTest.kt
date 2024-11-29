package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoMatcherTest : StringSpec({
    "should match tickets with the correct winning category" {
        val winningNumbers = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)

        val matcher = LottoMatcher(winningNumbers, bonusNumber)

        val ticket1 = Lotto.of(listOf(1, 2, 3, 4, 8, 9))
        val ticket2 = Lotto.of(listOf(1, 2, 3, 4, 5, 9))
        val ticket3 = Lotto.of(listOf(1, 2, 3, 4, 5, 7))
        val ticket4 = Lotto.of(listOf(1, 2, 3, 4, 5, 6))

        matcher.match(ticket1) shouldBe WinningCategory.FOURTH
        matcher.match(ticket2) shouldBe WinningCategory.THIRD
        matcher.match(ticket3) shouldBe WinningCategory.SECOND
        matcher.match(ticket4) shouldBe WinningCategory.FIRST
    }

    "should return SECOND when 5 numbers match and bonus number matches" {
        val winningLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)
        val matcher = LottoMatcher(winningLotto, bonusNumber)

        val ticket = Lotto.of(listOf(1, 2, 3, 4, 5, 7))
        matcher.match(ticket) shouldBe WinningCategory.SECOND
    }

    "should return THIRD when 5 numbers match and bonus number does not match" {
        val winningLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)
        val matcher = LottoMatcher(winningLotto, bonusNumber)

        val ticket = Lotto.of(listOf(1, 2, 3, 4, 5, 8))
        matcher.match(ticket) shouldBe WinningCategory.THIRD
    }
})
