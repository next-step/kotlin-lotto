package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row

class AmountTest : BehaviorSpec({
    Given("로또 한장 가격보다 적은 금액이 주어지면") {
        When("Amount는") {
            Then("에러를 발생한다.") {
                forAll(
                    row(-1),
                    row(0),
                    row(1),
                    row(999),
                ) { value ->
                    shouldThrow<IllegalArgumentException> {
                        Amount(value)
                    }
                }
            }
        }
    }
})
