package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : BehaviorSpec({

    Given("서로 다른 6개의 숫자와 보너스 번호가 주어지면") {
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.from(7)
        When("당첨 번호가") {
            val winningLotto = WinningLotto(lotto, bonusNumber)
            Then("생성된다.") {
                winningLotto.lotto shouldBe lotto
            }
        }
    }
})
