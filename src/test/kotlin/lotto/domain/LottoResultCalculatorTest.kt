package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.maps.shouldContain
import io.kotest.matchers.shouldBe

class LottoResultCalculatorTest : BehaviorSpec({
    Given("지난주 당첨 번호와 구매한 로또, 보너스볼 번호를 입력하면") {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.from(7)
        val winningLotto = WinningLotto(Lotto(winningNumbers), bonusNumber)
        val lotto = Lotto(1, 2, 3, 4, 5, 7)
        When("당첨 결과 계산기는") {
            val calculator = LottoResultCalculator(winningLotto)
            Then("각 등수 별로 당첨된 개수를 알려준다.") {
                calculator.calculateResult(listOf(lotto)).shouldContain(Rank.SECOND, 1)
            }
        }
    }

    Given("로또 결과를 입력하면") {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.from(7)
        val winningLotto = WinningLotto(Lotto(winningNumbers), bonusNumber)
        val result = mapOf(Rank.FIFTH to 1)
        When("당첨 결과 계산기는") {
            val calculator = LottoResultCalculator(winningLotto)
            Then("총 수익률을 계산하여 반환한다.") {
                calculator.calculateEarningRate(result, 14_000) shouldBe 0.35
            }
        }
    }
})
