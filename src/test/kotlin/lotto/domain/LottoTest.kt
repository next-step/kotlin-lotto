package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoTest : BehaviorSpec({

    Given("로또를 구매할 정보가 존재하고") {
        val purchase = LottoPurchase.valueOf("5000")
        When("로또 상점에 로또 구매 요청을 한다면") {
            val lotto = LottoShop.buyLotto(purchase)
            Then("금액 천원 단위 만큼 로또를 반환한다.") {
                lotto.autoLines.size shouldBe 5
            }
            Then("각 라인에는 6개의 숫자가 존재한다.") {
                lotto.autoLines.all { it.line.size == 6 }
            }
        }
    }

    Given("로또에 추첨 번호가 주어지면") {
        val lotto = Lotto(
            listOf(
                LottoLine.valueOf("1, 2, 3, 4, 5, 6"),
                LottoLine.valueOf("1, 2, 3, 4, 5, 7"),
                LottoLine.valueOf("1, 2, 3, 4, 8, 9"),
                LottoLine.valueOf("1, 2, 3, 8, 9, 10"),
            )
        )
        val winningNumbers = "1, 2, 3, 4, 5, 6"
        val bonusNumber = 7
        val lottoWinningNumber = LottoWinningNumber(LottoLine.valueOf(winningNumbers), LottoNumber.from(bonusNumber))
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
