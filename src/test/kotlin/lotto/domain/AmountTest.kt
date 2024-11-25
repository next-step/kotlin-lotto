package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class AmountTest : BehaviorSpec({

    Given("로또 구입 금액이 주어졌을 때") {
        forAll(
            row(14000, 14),
            row(1000, 1),
            row(2000, 2),
            row(2500, 2),
            row(2999, 2),
        ) { amount, expectedCount ->
            When("로또 구입 금액이 ${amount}원일 때") {
                val count = Amount(amount).calculateLottoCount()

                Then("구입 가능한 로또 개수는 ${expectedCount}개이다") {
                    count shouldBe expectedCount
                }
            }
        }

        forAll(
            row(999),
            row(0),
        ) { amount ->
            When("구입 금액이 최소금액에 충족하지 못하면") {
                Then("예외가 발생한다") {
                    shouldThrow<IllegalArgumentException> {
                        Amount(amount).calculateLottoCount()
                    }.message shouldBe "구입 금액은 최소 1000원 이상이어야 합니다."
                }
            }
        }
    }
})
