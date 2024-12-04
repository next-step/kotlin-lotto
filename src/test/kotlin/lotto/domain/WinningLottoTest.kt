package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : StringSpec({
    "should return NONE for tickets with no matching numbers" {
        val winningNumbers = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val ticket = Lotto.of(listOf(8, 9, 10, 11, 12, 13))

        val category = winningLotto.evaluateTickets(LottoTickets(listOf(ticket))).first()

        category shouldBe WinningCategory.NONE
    }

    "should return FIFTH for tickets with 3 matching numbers" {
        val winningNumbers = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val ticket = Lotto.of(listOf(1, 2, 3, 8, 9, 10))

        val category = winningLotto.evaluateTickets(LottoTickets(listOf(ticket))).first()

        category shouldBe WinningCategory.FIFTH
    }

    "should return FOURTH for tickets with 4 matching numbers" {
        val winningNumbers = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val ticket = Lotto.of(listOf(1, 2, 3, 4, 8, 9))

        val category = winningLotto.evaluateTickets(LottoTickets(listOf(ticket))).first()

        category shouldBe WinningCategory.FOURTH
    }

    "should return THIRD for tickets with 5 matching numbers and no bonus" {
        val winningNumbers = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val ticket = Lotto.of(listOf(1, 2, 3, 4, 5, 8))

        val category = winningLotto.evaluateTickets(LottoTickets(listOf(ticket))).first()

        category shouldBe WinningCategory.THIRD
    }

    "should return SECOND for tickets with 5 matching numbers and bonus" {
        val winningNumbers = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val ticket = Lotto.of(listOf(1, 2, 3, 4, 5, 7))

        val category = winningLotto.evaluateTickets(LottoTickets(listOf(ticket))).first()

        category shouldBe WinningCategory.SECOND
    }

    "should return FIRST for tickets with 6 matching numbers" {
        val winningNumbers = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val ticket = Lotto.of(listOf(1, 2, 3, 4, 5, 6))

        val category = winningLotto.evaluateTickets(LottoTickets(listOf(ticket))).first()

        category shouldBe WinningCategory.FIRST
    }
})
