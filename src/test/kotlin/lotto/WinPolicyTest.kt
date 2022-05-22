package lotto

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

    "숫자 일치 0 제공하면 에러가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            WinPolicy(0, Money(1000))
        }
    }

    "숫자 일치 개수가 로또의 숫자 개수보다 크면 에러가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            WinPolicy(Lotto.NUMBER_COUNT + 1, Money(1000))
        }
    }
})
