package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : BehaviorSpec({

    val lottoMachine = LottoMachine()
    Given("로또 당첨 번호 6개와 보너스 번호가 주어지고") {
        val winningNumbers = "1, 2, 3, 4, 5, 6"
        val bonusNumber = "7"
        val winningNumber = LottoWinningNumber.of(winningNumbers, bonusNumber)
        When("복권 기계에 구매한 로또를 전달하면") {
            val lotto = Lotto(
                listOf(
                    LottoNumber(listOf(1, 2, 3, 4, 5, 6)),
                    LottoNumber(listOf(1, 2, 3, 4, 5, 7)),
                    LottoNumber(listOf(1, 2, 3, 4, 5, 9)),
                    LottoNumber(listOf(1, 2, 3, 4, 8, 9)),
                    LottoNumber(listOf(1, 2, 3, 8, 9, 10))
                )
            )
            val lottoRanks = lottoMachine.checkLottoResult(lotto, winningNumber)
            Then("로또 결과를 반환한다.") {
                println(lottoRanks)
                lottoRanks shouldBe LottoWinningReceipt(
                    mapOf(
                        LottoRank.FIRST to 1,
                        LottoRank.SECOND to 1,
                        LottoRank.THIRD to 1,
                        LottoRank.FOURTH to 1,
                        LottoRank.FIFTH to 1
                    )
                )
            }
        }
    }
})
