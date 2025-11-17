package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : BehaviorSpec({
    Given("당첨 로또의 숫자가 1, 2, 3, 4, 5, 6 이고 로또는 당첨된 숫자가 하나도 없다.") {
        val winLotto = WinLotto("1 2 3 4 5 6")
        val lottos = listOf(Lotto(listOf(7, 8, 9, 10, 11, 12)))
        val lottoResult = LottoResult(winLotto, lottos)

        When("수행") {
            lottoResult.process()
            Then("다 MISS가 1개 나오고 수익률은 0입니다.") {
                lottoResult.matchMap shouldBe mapOf(Pair(Rank.MISS, 1))
                lottoResult.rateOfReturn shouldBe 0.0
            }
        }
    }

    Given("당첨 로또의 숫자가 1, 2, 3, 4, 5, 6 이고 로또는 1등 당첨") {
        val winLotto = WinLotto("1 2 3 4 5 6")
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val lottoResult = LottoResult(winLotto, lottos)

        When("수행") {
            lottoResult.process()
            Then("다 FIRST가 1개 나오고 수익률은 2000000.0입니다.") {
                lottoResult.matchMap shouldBe mapOf(Pair(Rank.FIRST, 1))
                lottoResult.rateOfReturn shouldBe 2000000.0
            }
        }
    }

    Given("당첨 로또의 숫자가 1, 2, 3, 4, 5, 6 이고 로또는 1등 당첨, 로또를 2장삼") {
        val winLotto = WinLotto("1 2 3 4 5 6")
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(2, 5, 10, 11, 12, 13)))
        val lottoResult = LottoResult(winLotto, lottos)

        When("수행") {
            lottoResult.process()
            Then("다 FIRST가 1개, MISS가 1개 나오고 수익률은 1000000.0입니다.") {
                lottoResult.matchMap shouldBe mapOf(Pair(Rank.FIRST, 1), Pair(Rank.MISS, 1))
                lottoResult.rateOfReturn shouldBe 1000000.0
            }
            lottoResult.printResult()
        }
    }
})
