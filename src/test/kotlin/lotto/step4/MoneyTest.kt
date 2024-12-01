package lotto.step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step4.domain.Money

class MoneyTest : FunSpec({
    test("Money 클래스 plus 연산 테스트") {
        val money1 = Money(1000)
        val money2 = Money(2000)
        val result = money1 + money2
        result.value shouldBe 3000
    }

    test("Money 클래스 minus 연산 테스트") {
        val money1 = Money(2000)
        val money2 = Money(1000)
        val result = money1 - money2
        result.value shouldBe 1000
    }

    test("Money 클래스 minus 결과가 음수가 되는 경우 테스트") {
        val money1 = Money(1000)
        val money2 = Money(2000)
        val result = money1 - money2
        result.value shouldBe -1000
    }

    test("Money 클래스 multiply 연산 테스트") {
        val money = Money(1000)
        val result = money.multiply(5)
        result.value shouldBe 5000
    }

    test("Money 클래스 div 연산 테스트 - 나눗셈 정상 케이스") {
        val money1 = Money(2000)
        val money2 = Money(1000)
        val result = money1 / money2
        result shouldBe 2
    }

    test("Money 클래스 div 연산 테스트 - 0으로 나누는 경우") {
        val money1 = Money(2000)
        val money2 = Money(0)
        val result = money1 / money2
        result shouldBe 0
    }

    test("Money 클래스 toString 테스트") {
        val money = Money(1000)
        money.toString() shouldBe "1000"
    }
})
