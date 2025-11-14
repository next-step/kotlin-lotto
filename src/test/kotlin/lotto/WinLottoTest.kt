package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class WinLottoTest : BehaviorSpec({

    Given("1. 로또 당첨번호 생성") {
        When("문자가 포함된 경우") {
            val exception =
                shouldThrow<IllegalArgumentException> { WinLotto("1 2 3 4 5 육") }
            Then("예외를 던진다") {
                exception.message shouldBe "올바른 숫자를 입력하세요"
            }
        }
    }

    Given("2. 로또 당첨번호 생성") {
        When("1보다 작거나 45보다 큰 숫자가 포함된 경우") {
            val exception =
                shouldThrow<IllegalArgumentException> { WinLotto("0 2 3 4 5 46") }
            Then("예외를 던진다") {
                exception.message shouldBe "1부터 45까지의 숫자를 입력하세요"
            }
        }
    }

    Given("3. 로또 당첨번호 생성") {
        When("5개의 숫자를 입력하는 경우") {
            val exception =
                shouldThrow<IllegalArgumentException> { WinLotto("2 4 6 8 10") }
            Then("예외를 던진다") {
                exception.message shouldBe "6개의 서로 다른 숫자를 입력하세요"
            }
        }
    }

    Given("4. 로또 당첨번호 생성") {
        When("6개 숫자 간 중복이 있는 경우") {
            val exception =
                shouldThrow<IllegalArgumentException> { WinLotto("2 4 6 8 10 2") }
            Then("예외를 던진다") {
                exception.message shouldBe "6개의 서로 다른 숫자를 입력하세요"
            }
        }
    }
})
