package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoLastNumbersTest : StringSpec({

    "지난주 당첨번호는 6개의 숫자와 1개의 보너스 숫자를 가지고 있다" {
        val lastNumbers = LottoLastNumbers(numbers = setOf(1, 2, 3, 4, 5, 6), bonus = 7)
        lastNumbers.size shouldBe 6
        lastNumbers.bonus.number shouldBe 7
    }

    "지난주 당첨번호는 1~45 범위의 숫자를 입력하지 않은 경우 IllegalArgumentException을 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoLastNumbers(numbers = setOf(0, 2, 3, 4, 5, 6), bonus = 6)
        }
    }

    "지난주 당첨번호는 보너스 숫자를 1~45 범위의 숫자로 입력하지 않은 경우 IllegalArgumentException을 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoLastNumbers(numbers = setOf(1, 2, 3, 4, 5, 6), bonus = 46)
        }
    }

    "지난주 당첨번호는 6개 이하의 숫자를 입력하게 되면 IllegalArgumentException을 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoLastNumbers(numbers = setOf(1), bonus = 7)
        }
    }

    "지난주 당첨번호는 6개 이상의 숫자를 입력하게 되면 IllegalArgumentException을 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoLastNumbers(numbers = setOf(1, 2, 3, 4, 5, 6, 7), bonus = 8)
        }
    }

    "지난주 당첨번호는 입력한 6개 숫자중 동일한 번호를 보너스 번호로 입력하면 IllegalArgumentException을 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoLastNumbers(numbers = setOf(1, 2, 3, 4, 5, 6), bonus = 6)
        }
    }
})
