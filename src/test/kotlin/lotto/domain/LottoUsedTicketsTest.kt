package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see LottoUsedTicket
 */
class LottoUsedTicketsTest : FunSpec({

    context("fun evaluate()") {
        val winTicketNumber = LottoWinTicket.of("1,2,3,4,5,6", "13")
        val lottoUsedTickets = LottoUsedTickets(
            listOf(
                LottoUsedTicket(LottoNumbers.from("1,2,3,4,5,6")),
                LottoUsedTicket(LottoNumbers.from("13,2,3,4,5,6")),
                LottoUsedTicket(LottoNumbers.from("7,2,3,4,5,6")),
                LottoUsedTicket(LottoNumbers.from("7,8,3,4,5,6")),
                LottoUsedTicket(LottoNumbers.from("7,8,9,4,5,6")),
                LottoUsedTicket(LottoNumbers.from("7,8,9,10,5,6")),
                LottoUsedTicket(LottoNumbers.from("7,8,9,10,11,6")),
                LottoUsedTicket(LottoNumbers.from("7,8,9,10,11,12")),
            )
        )

        test("티켓들이 몇 등에 당첨되었는지 검증") {
            val rewards = lottoUsedTickets.evaluate(winTicketNumber)

            rewards shouldBe LottoRewards(
                listOf(
                    LottoReward.FIRST,
                    LottoReward.SECOND,
                    LottoReward.THIRD,
                    LottoReward.FIRTH,
                    LottoReward.FIFTH,
                    LottoReward.FAIL,
                    LottoReward.FAIL,
                    LottoReward.FAIL,
                )
            )
        }
    }
})
