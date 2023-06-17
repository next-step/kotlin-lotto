package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAnyUnit
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.throwable.shouldHaveMessage

class LotteryTest : StringSpec({
    "로또 길이는 6 자리이다" {
        shouldNotThrowAnyUnit {
            Lottery(setOf(1, 2, 3, 4, 5, 6))
        }
    }

    "로또 길이가 6 자리 아닐 경우" {
        shouldThrow<IllegalArgumentException> {
            Lottery(setOf(1, 2, 3, 4, 5, 6, 7))
        }.shouldHaveMessage("로또는 6자리입니다.")
    }

    "로또의 숫자가 1이상 45 이하인 경우" {
        shouldNotThrowAnyUnit {
            Lottery(setOf(1, 45, 44, 2, 43, 3))
        }
    }

    "로또의 숫자가 1이상 45 이하가 아닌 경우" {
        shouldThrow<IllegalArgumentException> {
            Lottery(setOf(1, 46, 44, 2, 43, 3))
        }.shouldHaveMessage("로또의 숫자는 1~45 사이의 정수가 가능합니다.")
    }
})
