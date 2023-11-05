package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
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

    Given("로또 당첨 번호가 , 기준으로 6개 주어지고") {
        val winningNumbers = "1, 2, 3, 4, 5, 6"

        When("복권 기계에 구매한 로또를 전달하면") {
            val lotto = Lotto(
                listOf(
                    listOf(1,2,3,4,5,6),
                    listOf(1,2,3,4,5,7),
                    listOf(1,2,3,4,7,8),
                    listOf(1,2,3,7,8,9),
                    listOf(1,2,3,7,8,9)
                )
            )
            val lottoRanks = LottoMachine(winningNumbers).checkLottoResult(lotto)
            Then("로또 결과를 반환한다.") {
                lottoRanks shouldBe LottoResult(
                    mapOf(
                        LottoRank.FIRST_PLACE to 1,
                        LottoRank.SECOND_PLACE to 1,
                        LottoRank.THIRD_PLACE to 1,
                        LottoRank.FOURTH_PLACE to 2
                    )
                )
            }
        }
    }
})
