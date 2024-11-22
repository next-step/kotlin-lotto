package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoNumberGeneratorTest : BehaviorSpec({
    Given("자동 로또 번호를 생성") {
        val generator = AutoLottoNumberGenerator()

        When("generate 메서드를 호출하면") {
            val numbers = generator.generate()

            Then("로또 번호는 6개이다") {
                numbers.size shouldBe 6
            }

            Then("모든 번호는 1부터 45 사이여야 한다") {
                numbers.all { it in 1..45 } shouldBe true
            }

            Then("중복된 번호는 없어야 한다") {
                numbers.size shouldBe numbers.toSet().size
            }
        }
    }
})
