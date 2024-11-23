package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class BonusNumberTest : BehaviorSpec({
    Given("보너스 번호가 주어졌을 때") {

        When("번호가 1부터 45 사이인 경우") {
            Then("정상적으로 생성된다") {
                BonusNumber(1).value shouldBe 1
                BonusNumber(45).value shouldBe 45
                BonusNumber(23).value shouldBe 23
            }
        }

        When("번호가 범위를 벗어난 경우") {
            Then("예외가 발생한다") {
                shouldThrow<IllegalArgumentException> { BonusNumber(0) }
                    .message shouldBe "로또 번호는 1부터 45 사이여야 합니다."

                shouldThrow<IllegalArgumentException> { BonusNumber(46) }
                    .message shouldBe "로또 번호는 1부터 45 사이여야 합니다."

                shouldThrow<IllegalArgumentException> { BonusNumber(-5) }
                    .message shouldBe "로또 번호는 1부터 45 사이여야 합니다."
            }
        }
    }
})
