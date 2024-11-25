package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoGeneratorTest : BehaviorSpec({
    Given("로또를 생성하면") {
        When("LottoGenerator로 자동 로또를 생성하면") {
            val lottoGenerator = LottoGenerator { setOf(1, 2, 3, 4, 5, 6) }
            val lotto = lottoGenerator.generate()

            Then("Lotto 객체가 생성되며 올바른 번호를 가진다") {
                lotto.numbers shouldBe setOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)
            }
        }
    }
})
