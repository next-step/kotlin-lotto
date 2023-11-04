package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Customer
import java.lang.IllegalArgumentException

class CustomerTest : BehaviorSpec({

    Given("로또를 구매할 금액이 입력되었을 때") {
        When("입력이 정수이고 천원 단위라면") {
            val money = "15000"
            Then("고객이 될 수 있다.") {
                Customer(money).money shouldBe 15000
            }
        }

        When("입력이 정수이지만 천원 단위가 아니라면") {
            val money = "15001"
            Then("입력이 잘못됐다는 예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    Customer(money)
                }
            }
        }

        When("입력이 정수가 아니라면") {
            val money = "1500a"
            Then("입력이 잘못됐다는 예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    Customer(money)
                }
            }
        }
    }
})
