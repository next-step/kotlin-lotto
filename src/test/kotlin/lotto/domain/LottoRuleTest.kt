package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoRuleTest : BehaviorSpec({
    Given("로또 번호 규칙이 주어졌을 때") {

        When("번호가 6개이고 1부터 45 사이인 경우") {
            val validNumbers = setOf(1, 2, 3, 4, 5, 6)

            Then("검증에 성공한다") {
                LottoRule.validate(validNumbers)
            }
        }

        When("번호의 개수가 6개가 아닌 경우") {
            forAll(
                row(setOf(1, 2, 3, 4, 5), "로또 번호는 6개여야 합니다."),
                row(setOf(1, 2, 3, 4, 5, 6, 7), "로또 번호는 6개여야 합니다."),
            ) { invalidNumbers, expectedMessage ->
                Then("예외가 발생하고 메시지는 '$expectedMessage'이어야 한다") {
                    val exception =
                        shouldThrow<IllegalArgumentException> {
                            LottoRule.validate(invalidNumbers)
                        }
                    exception.message shouldBe expectedMessage
                }
            }
        }

        When("번호가 1부터 45 사이가 아닌 경우") {
            forAll(
                row(setOf(0, 2, 3, 4, 5, 6), "로또 번호는 1부터 45 사이여야 합니다."),
                row(setOf(1, 2, 3, 4, 5, 46), "로또 번호는 1부터 45 사이여야 합니다."),
                row(setOf(-1, 2, 3, 4, 5, 6), "로또 번호는 1부터 45 사이여야 합니다."),
            ) { invalidNumbers, expectedMessage ->
                Then("예외가 발생하고 메시지는 '$expectedMessage'이어야 한다") {
                    val exception =
                        shouldThrow<IllegalArgumentException> {
                            LottoRule.validate(invalidNumbers)
                        }
                    exception.message shouldBe expectedMessage
                }
            }
        }
    }
})
