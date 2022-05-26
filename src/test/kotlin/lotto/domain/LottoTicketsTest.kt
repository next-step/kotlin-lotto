package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoTicketsTest : BehaviorSpec({

    Given("로또 번호 티켓 목록은") {
        val lottoTickets = LottoTickets(
            listOf(
                LottoTicket(setOf(1, 2, 3, 10, 11, 12)),
                LottoTicket(setOf(1, 2, 3, 4, 11, 12)),
                LottoTicket(setOf(1, 2, 3, 4, 5, 12)),
                LottoTicket(setOf(1, 2, 3, 4, 5, 7)),
                LottoTicket(setOf(1, 2, 3, 4, 5, 6)),
            )
        )
        val lottoLastNumbers = LottoLastNumbers(setOf(1, 2, 3, 4, 5, 6), 7)
        val matchResult = lottoTickets.getMatchResult(lottoLastNumbers)

        When("6개의 로또 번호 와 1개의 보너스 번호가 입력이 되면") {
            Then("3개 일치 개수를 반환한다") {
                matchResult[LottoMatch.THREE] shouldBe 1
            }
            Then("4개 일치 개수를 반환한다") {
                matchResult[LottoMatch.FOUR] shouldBe 1
            }
            Then("5개 일치 개수를 반환한다") {
                matchResult[LottoMatch.FIVE] shouldBe 1
            }
            Then("5개 + 보너스 번호 일치 개수를 반환한다") {
                matchResult[LottoMatch.FIVE_BONUS] shouldBe 1
            }
            Then("6개 일치 개수를 반환한다") {
                matchResult[LottoMatch.SIX] shouldBe 1
            }
        }

        When("0개의 로도 티켓 목록이 입력되면") {
            Then("IllegalArgumentException 예외 발생") {
                shouldThrowExactly<IllegalArgumentException> {
                    LottoTickets(emptyList())
                }
            }
        }
    }
})
