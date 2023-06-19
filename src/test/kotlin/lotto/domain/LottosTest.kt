package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.numberGenerator.NumberGenerator

class LottosTest : BehaviorSpec({

    val testNumberGenerator = object : NumberGenerator {
        override fun generateNumbers(): List<Int> {
            return listOf(1, 2, 3, 4, 5, 6)
        }
    }

    Given("구매 금액을 입력받으면") {
        val input = 2000
        When("로또를 생성할 때") {
            val lottos = Lottos.of(input, testNumberGenerator)
            Then("1장에 1000원이다.") {
                lottos.getSize() shouldBe 2
            }
        }
    }
})
