package lottery.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lottery.domain.lotto.Lotto

class WinningResultServiceSpec : BehaviorSpec({

    Given("당첨 결과 서비스는") {
        val winningResultService = WinningResultService()

        val lotto1 = Lotto(numbers = listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(numbers = listOf(1, 3, 5, 7, 9, 11))
        val lotto3 = Lotto(numbers = listOf(2, 4, 6, 8, 10, 12))
        val lotto4 = Lotto(numbers = listOf(7, 8, 9, 10, 11, 12))
        val lottos = listOf(lotto1, lotto2, lotto3, lotto4)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        When("로또와 당첨번호를 확인하여") {
            val result = winningResultService.draw(lottos, winningNumbers)

            println("result = $result")
            Then("당첨 결과를 반환한다") {
                result[3] shouldBe 2
                result[4] shouldBe 0
                result[5] shouldBe 0
                result[6] shouldBe 1
            }
        }
    }
})
