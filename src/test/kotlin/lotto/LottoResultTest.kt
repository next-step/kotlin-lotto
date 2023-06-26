package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoList
import lotto.domain.LottoNumbers
import lotto.domain.LottoResult

internal class LottoResultTest : BehaviorSpec({

    Given("LottoResult") {
        When("각 등수마다 1개씩 당첨됐을 때") {
            val mockLotto = Lotto(LottoNumbers(listOf(1, 2, 3)))
            val lottoResult = LottoResult(
                mapOf(
                    3 to LottoList(listOf(mockLotto)),
                    4 to LottoList(listOf(mockLotto)),
                    5 to LottoList(listOf(mockLotto)),
                    6 to LottoList(listOf(mockLotto))
                )
            )
            Then("getTotalPrize() 메서드는 result에 맞는 값을 반환한다.") {
                val actual = lottoResult.getTotalPrize()
                val expect = LottoResult.prizeMoneyMap.values.sum()
                actual shouldBe expect
            }
            Then("getRateOfReturn() 메서드는 총 상금 / 구매 가격을 반환한다.") {
                val actual = lottoResult.getRateOfReturn()
                val expect = LottoResult.prizeMoneyMap.values.sum() / 4000.0
                actual shouldBe expect
            }
        }

        When("각 등수마다 2개씩 당첨됐을 때") {
            val mockLotto = Lotto(LottoNumbers(listOf(1, 2, 3)))
            val lottoResult = LottoResult(
                mapOf(
                    3 to LottoList(listOf(mockLotto, mockLotto)),
                    4 to LottoList(listOf(mockLotto, mockLotto)),
                    5 to LottoList(listOf(mockLotto, mockLotto)),
                    6 to LottoList(listOf(mockLotto, mockLotto))
                )
            )
            Then("getTotalPrize() 메서드는 result에 맞는 값을 반환한다.") {
                val actual = lottoResult.getTotalPrize()
                val expect = LottoResult.prizeMoneyMap.values.sum() * 2
                actual shouldBe expect
            }
            Then("getRateOfReturn() 메서드는 총 상금 / 구매 가격을 반환한다.") {
                val actual = lottoResult.getRateOfReturn()
                val expect = LottoResult.prizeMoneyMap.values.sum() * 2L / 8000.0
                actual shouldBe expect
            }
        }
    }
})
