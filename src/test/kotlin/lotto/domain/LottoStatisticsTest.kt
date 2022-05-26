package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class LottoStatisticsTest : BehaviorSpec({

    Given("로또 통계는") {
        val lastLottoTicket = LottoTicket(setOf(1, 2, 3, 4, 5, 6))
        val lastLottoBonusNumber = 7
        val lottoTickets = listOf(
            LottoTicket(setOf(1, 2, 3, 10, 11, 12)),
            LottoTicket(setOf(1, 2, 3, 4, 11, 12)),
            LottoTicket(setOf(1, 2, 3, 4, 5, 12)),
            LottoTicket(setOf(1, 2, 3, 4, 5, 7)),
            LottoTicket(setOf(1, 2, 3, 4, 5, 6)),
        )

        When("1개 이상의 포함된 로또 티켓 목록이 입력되면") {
            val statistics = LottoStatistics(lottoTickets, lastLottoTicket, lastLottoBonusNumber)
            Then("3개 일치 개수를 반환한다") {
                statistics.getMatchCount(LottoMatch.THREE) shouldBe 1
            }
            Then("4개 일치 개수를 반환한다") {
                statistics.getMatchCount(LottoMatch.FOUR) shouldBe 1
            }
            Then("5개 일치 개수를 반환한다") {
                statistics.getMatchCount(LottoMatch.FIVE) shouldBe 1
            }
            Then("5개 + 보너스 번호 일치 개수를 반환한다") {
                statistics.getMatchCount(LottoMatch.FIVE_BONUS) shouldBe 1
            }
            Then("6개 일치 개수를 반환한다") {
                statistics.getMatchCount(LottoMatch.SIX) shouldBe 1
            }
            And("총 구매 금액을 입력하면") {
                val purchase = 4000
                val profit = BigDecimal(507888.75)
                Then("총 수익율을 반환한다") {
                    statistics.getProfit(purchase) shouldBe profit
                }
            }
        }

        When("0개의 로도 티켓 목록이 입력되면") {
            Then("IllegalArgumentException 예외 발생") {
                shouldThrowExactly<IllegalArgumentException> {
                    LottoStatistics(emptyList(), lastLottoTicket, lastLottoBonusNumber)
                }
            }
        }
    }
})
