package camp.nextstep.edu.step.step2.domain.amount

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import java.math.BigDecimal

@DisplayName("구매 금액은")
class BuyAmountTest : BehaviorSpec({

    Given("구매 금액이 주어지고") {
        val money = 14000L

        When("생성을 요청하면") {
            val buyAmount = BuyAmount(amount = money)

            Then("주어진 구매 금액이 생성된다") {
                buyAmount.amount shouldBe BigDecimal.valueOf(14000L)
            }
        }
    }

    Given("만약, 구매금액이 0원이 주어지고") {
        val money = 0L

        When("생성을 요청하면") {
            val buyAmount = shouldThrow<IllegalArgumentException> {
                BuyAmount(amount = money)
            }

            Then("예외가 발생한다") {
                buyAmount.message shouldBe "구매 금액은 0보다 커야 합니다."
            }
        }
    }
})
