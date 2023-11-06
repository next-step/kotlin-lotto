package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RandomLottoGeneratorTest : BehaviorSpec({
    Given("로또를 한번 구매할 때마다") {
        val randomLottoGenerator = RandomLottoGenerator()
        When("RandomLottoGenerator 는") {
            val lotto = randomLottoGenerator.generate()
            Then("6개의 서로 다른 숫자가 담긴 로또를 하나 발급한다.") {
                lotto.numbers.size shouldBe Lotto.LOTTO_COUNT
            }
        }
    }
})
