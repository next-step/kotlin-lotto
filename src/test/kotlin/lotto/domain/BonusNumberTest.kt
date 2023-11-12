package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class BonusNumberTest : FunSpec({
    test("보너스 번호는 1부터 45 사이의 숫자다.") {
        shouldNotThrow<Exception> { BonusNumber(15) }
    }

    test("보너스 번호가 1부터 45 사이의 숫자가 아니라면 예외가 발생한다.") {
        shouldThrow<RuntimeException> { BonusNumber(50) }
    }

    context("보너스 번호는 어떤 숫자 그룹에 자신의 값이 속해있는지 알 수 있다.") {
        withData(
            row(setOf(1, 2, 3, 4, 5, 6), 1, false),
            row(setOf(1, 2, 3, 4, 5, 6), 2, false),
            row(setOf(1, 2, 3, 4, 5, 6), 3, false),
            row(setOf(1, 2, 3, 4, 5, 6), 4, false),
            row(setOf(1, 2, 3, 4, 5, 6), 5, false),
            row(setOf(1, 2, 3, 4, 5, 6), 6, false),
            row(setOf(1, 2, 3, 4, 5, 6), 7, true)
        ) { (numbers, bonus, expected) ->
            val winningNumbers = LottoNumbers(numbers)
            val bonusNumber = BonusNumber(bonus)
            bonusNumber notIn winningNumbers shouldBe expected
        }
    }
})
