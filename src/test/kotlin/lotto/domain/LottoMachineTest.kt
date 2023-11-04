package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoMachineTest : BehaviorSpec({

    Given("로또 당첨 번호가 , 기준으로 6개 주어진다면") {
        val winningNumbers = "1, 2, 3, 4, 5, 6"
        Then("로또 머신을 생성할 수 있다.") {
            LottoMachine(winningNumbers)
        }
    }

    Given("로또 당첨 번호가 , 기준으로 6개가 아니거나 문자가 들어온다면") {
        val fiveNumber = "1, 2, 3, 4, 5"
        val containChar = "1, 2, a, 4, 5, 6"
        Then("예외를 반환한다.") {
            shouldThrow<IllegalArgumentException> {
                LottoMachine(fiveNumber)
            }

            shouldThrow<IllegalArgumentException> {
                LottoMachine(containChar)
            }
        }
    }
})
