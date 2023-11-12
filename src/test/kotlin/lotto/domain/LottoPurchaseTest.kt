package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoPurchaseTest : BehaviorSpec({

    Given("로또를 구매할 금액이 입력되었을 때") {
        When("입력이 정수이고 천원 단위라면") {
            val money = "15000"
            Then("생성이 가능합니다.") {
                LottoPurchase.valueOf(money).money shouldBe 15000
            }
        }

        When("입력이 정수가 아니라면") {
            val money = "1500a"
            Then("입력이 잘못됐다는 예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    LottoPurchase.valueOf(money)
                }
            }
        }

        When("수동 구매 수량이 로또 구매 금액을 초과한다면") {
            val money = "15000"
            val manualQuantity = "16"
            Then("입력이 잘못됐다는 예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    LottoPurchase.valueOf(money, manualQuantity)
                }
            }
        }
    }
})
