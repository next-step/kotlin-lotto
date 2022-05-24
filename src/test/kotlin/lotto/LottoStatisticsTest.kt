package lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoStatisticsTest : BehaviorSpec({

    Given("로또 통계는") {
        val lastLottoNumbers = setOf(1, 2, 3, 4, 5, 6)
        val lottoTickets = listOf(
            LottoTicket(listOf(1, 2, 3, 10, 11, 12)),
            LottoTicket(listOf(1, 2, 3, 4, 11, 12)),
            LottoTicket(listOf(1, 2, 3, 4, 5, 12)),
            LottoTicket(listOf(1, 2, 3, 4, 5, 6)),
        )

        When("1개 이상의 포함된 로또 티켓 목록이 입력되면") {
            val statistics = LottoStatistics(lottoTickets, lastLottoNumbers)
            Then("3개 일치 개수를 반환한다") {
                statistics.getMatchCount(LottoMatch.THREE) shouldBe 1
            }
            Then("4개 일치 개수를 반환한다") {
                statistics.getMatchCount(LottoMatch.FOUR) shouldBe 1
            }
            Then("5개 일치 개수를 반환한다") {
                statistics.getMatchCount(LottoMatch.FIVE) shouldBe 1
            }
            Then("6개 일치 개수를 반환한다") {
                statistics.getMatchCount(LottoMatch.SIX) shouldBe 1
            }
            And("총 구매 금액을 입력하면") {
                val purchase = 4000
                val reward = 5000 + 50000 + 1500000 + 2000000000
                val profit = reward / purchase
                Then("총 수익율을 반환한다") {
                    statistics.getProfit(purchase) shouldBe profit
                }
            }
        }

        When("0개의 로도 티켓 목록이 입력되면") {
            Then("IllegalArgumentException 예외 발생") {
                shouldThrowExactly<IllegalArgumentException> {
                    LottoStatistics(emptyList(), lastLottoNumbers)
                }
            }
        }
    }
})
