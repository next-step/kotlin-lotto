package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MoneyTest : StringSpec({
    "Money 는 덧셈 연산을 할 수 있다" {
        val money1000 = Money(1000)
        val money2000 = Money(2000)

        val result = money1000 + money2000

        result shouldBe Money(3000)
    }

    "Money는 뺄셈 연산을 할 수 있다" {
        val money1000 = Money(1000)
        val money2000 = Money(2000)

        val result = money1000 - money2000

        result shouldBe Money(-1000)
    }

    "Money 는 서로 비교할 수 있다" {

        val money1 = Money(1000)
        val money2 = Money(1001)
        val money3 = Money(1000)

        (money1 < money2) shouldBe true
        (money1 == money3) shouldBe true
        (money2 > money3) shouldBe true
        (money2 == money3) shouldBe false
    }

    "Money는 ZERO 라는 초기값을 제공한다" {
        Money.ZERO shouldBe Money(0)
    }

    "Money는 Int 타입으로 변환할 수 있다" {
        val money1000 = Money(1000)

        money1000.toLong() shouldBe 1000
    }

    "Money는 Double 타입으로 변환할 수 있다" {
        val money1000 = Money(1000)

        money1000.toDouble() shouldBe 1000.0
    }
})
