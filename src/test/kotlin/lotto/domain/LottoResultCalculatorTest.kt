package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.maps.shouldContain

class LottoResultCalculatorTest : BehaviorSpec({
    Given("지난주 당첨 번호와 구매한 로또를 입력하면") {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(7),
                LottoNumber(8),
                LottoNumber(9)
            )
        )
        When("당첨 결과 계산기는") {
            val calculator = LottoResultCalculator(winningNumbers)
            Then("각 등수 별로 당첨된 개수를 알려준다.") {
                calculator.calculateResult(listOf(lotto)).shouldContain(Rank.FIFTH, 1)
            }
        }
    }
})
