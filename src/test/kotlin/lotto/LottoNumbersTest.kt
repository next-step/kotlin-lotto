package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : BehaviorSpec({

    Given("로또 번호에") {
        When("로또 번호를 생성하면") {
            val lottoNumbers = LottoNumbers.created(listOf(1, 2, 3, 4, 5, 6))

            Then("로또 번호는 6개를 가진다") {
                lottoNumbers.numbers.size shouldBe 6
            }

            Then("로또 번호는 1부터 45까지의 숫자로 이루어져 있다") {
                lottoNumbers.numbers.all { it.value in 1..45 } shouldBe true
            }

            Then("로또 번호는 중복되지 않는다") {
                lottoNumbers.numbers.toSet().size shouldBe 6
            }
        }

        When("당첨 번호를 받아서") {
            val lottoNumbers = LottoNumbers.created(listOf(1, 2, 3, 4, 5, 6))
            val winningNumbers = LottoNumbers.created(listOf(1, 2, 3, 4, 5, 6))

            Then("로또 번호와 당첨 번호를 비교하면 6개가 일치한다") {
                lottoNumbers.countMatch(winningNumbers) shouldBe 6
            }
        }
    }
})
