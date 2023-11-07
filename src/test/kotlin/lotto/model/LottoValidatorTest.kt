package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.collection.LottoTicket

//class LottoValidatorTest : BehaviorSpec({
//    Given("티켓 3개 리스트, 당첨 번호") {
//        val lottoTickets = listOf<LottoTicket>(
//            LottoTicket(numbers = listOf(1, 2, 3, 4, 5, 6)),
//            LottoTicket(numbers = listOf(3, 4, 5, 6, 7, 8)),
//            LottoTicket(numbers = listOf(5, 6, 7, 8, 9, 10))
//        )
//        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
//        val ticketLength = 6
//        When("로또를 검증기가 검증했을때") {
//            val result = LottoValidator.validate(lottoTickets, winningNumbers, ticketLength)
//            Then("티켓들이 몇개나 맞았는지 7개의 결과가 도출 된다") {
//                result.size shouldBe ticketLength + 1
//                result[0] shouldBe 0
//                result[1] shouldBe 0
//                result[2] shouldBe 1
//                result[3] shouldBe 0
//                result[4] shouldBe 1
//                result[5] shouldBe 0
//                result[6] shouldBe 1
//            }
//        }
//    }
//})
