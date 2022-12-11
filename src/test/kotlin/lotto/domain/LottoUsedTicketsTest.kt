package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see LottoUsedTicket
 */
class LottoUsedTicketsTest : FunSpec({

    context("LottoUsedTicket") {
        val winTicketNumber = LottoWinTicket.from("1,2,3,4,5,6")
        val lottoUsedTickets = LottoUsedTickets(
            listOf(
                LottoUsedTicket(LottoNumbers.from("1,2,3,4,5,6")),
                LottoUsedTicket(LottoNumbers.from("7,2,3,4,5,6")),
                LottoUsedTicket(LottoNumbers.from("7,8,3,4,5,6")),
                LottoUsedTicket(LottoNumbers.from("7,8,9,4,5,6")),
                LottoUsedTicket(LottoNumbers.from("7,8,9,10,5,6")),
                LottoUsedTicket(LottoNumbers.from("7,8,9,10,11,6")),
                LottoUsedTicket(LottoNumbers.from("7,8,9,10,11,12")),
            )
        )

        test("evaluate") {
            val rewards = lottoUsedTickets.evaluate(winTicketNumber)

            rewards shouldBe LottoRewards(
                listOf(
                    LottoReward.FIRST,
                    LottoReward.SECOND,
                    LottoReward.THIRD,
                    LottoReward.FIRTH,
                    LottoReward.FAIL,
                    LottoReward.FAIL,
                    LottoReward.FAIL,
                )
            )
        }

        test("toString") {
        }
    }
})
