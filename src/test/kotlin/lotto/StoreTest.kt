package lotto

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import lotto.domain.Store

class StoreTest : BehaviorSpec({

    Given("구입 금액이") {
        When("0이거나 그보다 작으면") {
            val nums = listOf(0, -1000)
            nums.forAll { num ->
                Then("IllegalArgumentException 예외가 발생한다.") {
                    shouldThrow<IllegalArgumentException> {
                        Store.buy(num)
                    }
                }
            }
        }

        When("1000원 단위가 아니면") {
            val nums = listOf(1, 100, 3700)
            nums.forAll { num ->
                Then("IllegalArgumentException 예외가 발생한다.") {
                    shouldThrow<IllegalArgumentException> {
                        Store.buy(num)
                    }
                }
            }
        }

        When("양수이고 1000원 단위이면") {
            val nums = listOf(1000, 3000, 10000)
            nums.forAll { num ->
                Then("정상적으로 로또가 발행된다.") {
                    shouldNotThrow<IllegalArgumentException> {
                        Store.buy(num)
                    }
                }
            }
        }
    }
})
