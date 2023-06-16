package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers

class LottoNumbersTest : BehaviorSpec({

    Given("로또를 한장 구매할 때") {
        val input = 1000
        When("로또 번호를 생성하면") {
            val lottoNumbers = LottoNumbers.create()
            Then("6개의 숫자가 생성된다.") {
                lottoNumbers.lottoNumbers.size shouldBe 6
            }
            Then("생성되는 숫자는 오름차순으로 정렬된다") {
                lottoNumbers.lottoNumbers shouldBe lottoNumbers.lottoNumbers.sorted()
            }
            Then("각 숫자는 1 ~ 45 사이이다.") {
                lottoNumbers.lottoNumbers.forEach { it ->
                    it shouldBeInRange 1..45
                }
            }
            Then("각 번호는 중복되지 않는다.") {
                lottoNumbers.lottoNumbers.toSet().size shouldBe 6
            }
        }
    }
})
