package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoTicketsTest : BehaviorSpec({

    Given("로또 티켓 목록은") {
        val lottoTickets = LottoTickets(
            listOf(
                LottoTicket.AutoLottoTicket(setOf(1, 2, 3, 10, 11, 12).toLottoNumber()),
                LottoTicket.AutoLottoTicket(setOf(1, 2, 5, 10, 11, 12).toLottoNumber()),
                LottoTicket.AutoLottoTicket(setOf(1, 2, 3, 4, 5, 6).toLottoNumber())
            )
        )
        val lottoLastNumbers = LottoLastNumbers(setOf(1, 2, 3, 4, 5, 6), 7)

        When("지난주 당첨번호를 입력하면") {
            Then("총 3개가 일치하는 통계를 반환한다") {
                val statistics = lottoTickets.getLottoStatistics(lottoLastNumbers)
                statistics.values.sum() shouldBe 3
            }
            Then("번호 1개가 일치하는 티켓 개수는 null을 반환한다") {
                val statistics = lottoTickets.getLottoStatistics(lottoLastNumbers)
                statistics[LottoMatch.ONE] shouldBe null
            }
            Then("번호 3개가 일치하는 티켓 개수는 2를 반환한다") {
                val statistics = lottoTickets.getLottoStatistics(lottoLastNumbers)
                statistics[LottoMatch.THREE] shouldBe 2
            }
            Then("번호 6개가 일치하는 티켓 개수는 1를 반환한다") {
                val statistics = lottoTickets.getLottoStatistics(lottoLastNumbers)
                statistics[LottoMatch.SIX] shouldBe 1
            }
        }
    }
})
