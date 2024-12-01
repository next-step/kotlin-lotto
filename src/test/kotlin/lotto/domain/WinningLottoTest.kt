package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : StringSpec({
    "should determine the correct winning category for tickets" {
        val winningNumbers = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val ticket1 = Lotto.of(listOf(1, 2, 3, 4, 8, 9))
        val ticket2 = Lotto.of(listOf(1, 2, 3, 4, 5, 9))
        val ticket3 = Lotto.of(listOf(1, 2, 3, 4, 5, 7))
        val ticket4 = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val ticket5 = Lotto.of(listOf(8, 9, 10, 11, 12, 13))

        winningLotto.determineCategory(ticket1) shouldBe WinningCategory.FOURTH
        winningLotto.determineCategory(ticket2) shouldBe WinningCategory.THIRD
        winningLotto.determineCategory(ticket3) shouldBe WinningCategory.SECOND
        winningLotto.determineCategory(ticket4) shouldBe WinningCategory.FIRST
        winningLotto.determineCategory(ticket5) shouldBe WinningCategory.NONE
    }
})
