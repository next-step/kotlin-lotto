package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoTest : BehaviorSpec({

    Given("고객이 존재하고") {
        val customer = Customer.valueOf("5000")
        When("로또 상점에게 로또 구매 요청을 한다면") {
            val lotto = LottoShop().buyLotto(customer.money)
            Then("금액 천원 단위 만큼 로또를 반환한다.") {
                lotto.lines.size shouldBe 5
            }
            Then("각 라인에는 6개의 숫자가 존재한다.") {
                lotto.lines.all { it.line.size == 6 }
            }
        }
    }

    Given("로또에 추첨 번호가 주어지면") {
        val lotto = Lotto(
            listOf(
                LottoLine(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)),
                LottoLine(listOf(1, 2, 3, 4, 5, 7).map(::LottoNumber)),
                LottoLine(listOf(1, 2, 3, 4, 8, 9).map(::LottoNumber)),
                LottoLine(listOf(1, 2, 3, 8, 9, 10).map(::LottoNumber)),
            )
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)
        val bonusNumber = 7
        val lottoWinningNumber = LottoWinningNumber(LottoLine(winningNumbers), LottoNumber(bonusNumber))
        Then("각 라인별 동일한 번호의 개수 리스트를 반환한다.") {
            val sameNumberCount = lotto.getAllSameNumberCount(lottoWinningNumber)
            sameNumberCount.size shouldBe 4
            sameNumberCount shouldBe listOf(
                LottoWinningResult(6, false),
                LottoWinningResult(5, true),
                LottoWinningResult(4, false),
                LottoWinningResult(3, false)
            )
        }
    }
})
