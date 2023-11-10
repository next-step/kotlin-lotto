package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.collection.LottoNumber
import lotto.collection.LottoTicket

class LottoValidatorTest : BehaviorSpec({
    Given("티켓 3개 리스트, 당첨 번호") {
        val lottoTickets = listOf<LottoTicket>(
            LottoTicket(numbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }),
            LottoTicket(numbers = listOf(3, 4, 5, 6, 7, 8).map { LottoNumber.from(it) }),
            LottoTicket(numbers = listOf(5, 6, 7, 8, 9, 10).map { LottoNumber.from(it) })
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }
        When("로또를 검증기가 검증했을때") {
            val lottoResults = LottoValidator.validate(lottoTickets, winningNumbers)
            Then("티켓들이 몇개나 맞았는지 7개의 결과가 도출 된다") {
                lottoResults.results["0"] shouldBe 0
                lottoResults.results["1"] shouldBe 0
                lottoResults.results["2"] shouldBe 1
                lottoResults.results["3"] shouldBe 0
                lottoResults.results["4"] shouldBe 1
                lottoResults.results["5"] shouldBe 0
                lottoResults.results["6"] shouldBe 1
            }
        }
    }
})
