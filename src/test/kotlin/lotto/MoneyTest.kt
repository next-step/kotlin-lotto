package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class MoneyTest : BehaviorSpec({
    Given("1. 잘못된 케이스 입력") {
        When("input이 null") {
            val input = null
            val exception =
                shouldThrow<IllegalArgumentException> { Money(input) }
            Then("예외가 나온다") {
                exception.message shouldBe "뭐라도 입력하세요"
            }
        }
    }

    Given("2. 잘못된 케이스 입력") {
        When("input이 빈 문자열") {
            val input = ""
            val exception =
                shouldThrow<IllegalArgumentException> { Money(input) }
            Then("예외가 나온다") {
                exception.message shouldBe "뭐라도 입력하세요"
            }
        }
    }

    Given("3. 잘못된 케이스 입력") {
        When("input이 스페이스바 문자열") {
            val input = " "
            val exception =
                shouldThrow<IllegalArgumentException> { Money(input) }
            Then("예외가 나온다") {
                exception.message shouldBe "뭐라도 입력하세요"
            }
        }
    }

    Given("4. 잘못된 케이스 입력") {
        When("input에 문자가 포함된 경우") {
            val input = "10000원"
            val exception =
                shouldThrow<IllegalArgumentException> { Money(input) }
            Then("예외가 나온다") {
                exception.message shouldBe "올바른 금액을 입력하세요"
            }
        }
    }

    Given("5. 잘못된 케이스 입력") {
        When("input이 양수가 아닌 경우") {
            val input = "-1000"
            val exception =
                shouldThrow<IllegalArgumentException> { Money(input) }
            Then("예외가 나온다") {
                exception.message shouldBe "올바른 금액을 입력하세요"
            }
        }
    }

    Given("6. 잘못된 케이스 입력") {
        When("input이 0원인 경우") {
            val input = "0"
            val exception =
                shouldThrow<IllegalArgumentException> { Money(input) }
            Then("예외가 나온다") {
                exception.message shouldBe "올바른 금액을 입력하세요"
            }
        }
    }
})
