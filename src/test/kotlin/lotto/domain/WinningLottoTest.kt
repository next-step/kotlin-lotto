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

    Given("다른 로또를 입력받으면") {
        val winningLotto = WinningLotto(Lotto(1, 2, 3, 4, 5, 6), LottoNumber.from(7))
        val other = Lotto(1, 2, 3, 7, 8, 9)
        When("당첨 번호는") {
            val matchCount = winningLotto.matchCount(other)
            Then("보너스 넘버를 제외하고 겹치는 로또 번호가 몇 개인지 반환한다.") {
                matchCount shouldBe 3
            }
        }
    }
})
