package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class BonusNumberTest : BehaviorSpec({
    Given("보너스 번호와 당첨 번호가 주어졌을 때") {
        val winningNumbers = Lotto.from(setOf(1, 2, 3, 4, 5, 6))
        When("보너스 번호가 당첨 번호와 중복되지 않을 경우") {

            val bonusNumber = BonusNumber.create(7, winningNumbers)

            Then("정상적으로 생성된다") {
                bonusNumber.value shouldBe LottoNumber(7)
            }
        }

        When("보너스 번호가 당첨 번호와 중복될 경우") {
            Then("예외가 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    BonusNumber.create(5, winningNumbers)
                }.message shouldBe "보너스 번호는 당첨 번호와 중복될 수 없습니다."
            }
        }
        forAll(
            row(0),
            row(46),
            row(-5),
        ) { bonusNumber ->
            When("번호가 범위를 벗어난 경우") {
                Then("예외가 발생한다") {
                    shouldThrow<IllegalArgumentException> { BonusNumber.create(bonusNumber, winningNumbers) }
                        .message shouldBe "로또 번호는 1부터 45 사이여야 합니다."
                }
            }
        }
    }
})
