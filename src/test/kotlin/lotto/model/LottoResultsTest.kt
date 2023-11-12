package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoResultsTest : BehaviorSpec({
    Given("로또 당첨 번호가 1, 2, 3, 4, 5, 6 이고 보너스 넘버가 7일때 ") {
        val lottoResults = LottoResults(
            listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) },
            LottoNumber.from(7)
        )
        When("로또 결과가 1, 2, 3, 4, 5, 6 생성 했을 때") {
            val ticketNumberList = listOf(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })
            val results = lottoResults.getResults(ticketNumberList)
            Then("1등") {
                results[Prize.FIRST] shouldBe 1
            }
            Then("수익률은") {
                val profit = lottoResults.getProfit(results)
                profit shouldBe 2000000.0
            }
        }
        When("로또 결과가 1, 2, 3, 4, 7, 16 생성 했을 때") {
            val ticketNumberList = listOf(listOf(1, 2, 3, 4, 7, 16).map { LottoNumber.from(it) })
            val results = lottoResults.getResults(ticketNumberList)
            Then("2등") {
                results[Prize.SECOND] shouldBe 1
            }
            Then("수익률은") {
                val profit = lottoResults.getProfit(results)
                profit shouldBe 30000.0
            }
        }
        When("로또 결과가 1, 2, 3, 4, 5, 16 생성 했을 때") {
            val ticketNumberList = listOf(listOf(1, 2, 3, 4, 5, 16).map { LottoNumber.from(it) })
            val results = lottoResults.getResults(ticketNumberList)
            Then("3등") {
                results[Prize.THIRD] shouldBe 1
            }
            Then("수익률은") {
                val profit = lottoResults.getProfit(results)
                profit shouldBe 1500.0
            }
        }
        When("로또 결과가 1, 2, 3, 4, 15, 16 생성 했을 때") {
            val ticketNumberList = listOf(listOf(1, 2, 3, 4, 15, 16).map { LottoNumber.from(it) })
            val results = lottoResults.getResults(ticketNumberList)
            Then("4등") {
                results[Prize.FOURTH] shouldBe 1
            }
            Then("수익률은") {
                val profit = lottoResults.getProfit(results)
                profit shouldBe 50.0
            }
        }
    }
})
