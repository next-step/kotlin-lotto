package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class WinPolicyTest : FreeSpec({

    "숫자 일치 개수와 당첨 금액을 받아서 정책을 생성한다" {
        val winPolicy = WinPolicy(3, Money(1000))

        winPolicy.matchCount shouldBe 3
        winPolicy.priceAmount shouldBe Money(1000)
    }

    "숫자 일치 개수에 음수를 제공하면 에러가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            WinPolicy(-1, Money(1000))
        }
    }

    "숫자 일치 개수에 0 을 제공하면 에러가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            WinPolicy(0, Money(1000))
        }
    }

    "숫자 일치 개수가 로또의 숫자 개수보다 크면 에러가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            WinPolicy(Lotto.NUMBER_COUNT + 1, Money(1000))
        }
    }

    "주어진 로또가 조건에 일치하는지 확인한다" {
        val winPolicy = WinPolicy(4, Money(1000))
        val winNumbers = WinNumbers.of(listOf(3, 4, 5, 6, 7, 8), 9)

        val matched = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        winPolicy.isMatch(winNumbers, matched) shouldBe true

        val notMatched = Lotto.of(listOf(1, 2, 3, 4, 5, 9))
        winPolicy.isMatch(winNumbers, notMatched) shouldBe false
    }

    "주어진 로또가 보너스 볼 조건에 일치하는지 확인한다" {
        val winPolicy = WinPolicy(3, Money(1000), true)
        val winNumbers = WinNumbers.of(listOf(3, 4, 5, 6, 7, 8), 9)

        val matched = Lotto.of(listOf(1, 2, 3, 4, 5, 9))
        winPolicy.isMatch(winNumbers, matched) shouldBe true

        val notMatched = Lotto.of(listOf(1, 2, 3, 4, 5, 10))
        winPolicy.isMatch(winNumbers, notMatched) shouldBe false
    }
})
