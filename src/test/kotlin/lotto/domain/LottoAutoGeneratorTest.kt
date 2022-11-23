package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class LottoAutoGeneratorTest : BehaviorSpec({
    Given("자동으로 생성하는 Generator로 ") {
        val lottoAutoGenerator = LottoAutoGenerateStrategy()

        When("로또 번호들을 생성하면 ") {
            val lottoNumbers = lottoAutoGenerator.generate()

            Then("6개의 숫자를 랜덤으로 생성한다.") {
                lottoNumbers.size shouldBe 6
            }
        }
    }
})
