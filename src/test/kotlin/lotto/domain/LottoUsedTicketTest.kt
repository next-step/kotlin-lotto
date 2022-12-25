package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see LottoUsedTicket
 */
class LottoUsedTicketTest : FunSpec({

    context("LottoUsedTickets") {
        val selectedString = "1, 2, 3, 4, 5, 6"
        val bonusString = "13"
        val lottoNumbers = LottoNumbers.from(selectedString)
        val lottoUsedTicket = LottoUsedTicket(lottoNumbers)
        val lottoWinTicket = LottoWinTicket.of(selectedString, bonusString)

        test("evaluate") {
            val reward = lottoUsedTicket.evaluate(lottoWinTicket)

            reward shouldBe LottoReward.FIRST
        }

        test("toString") {
            lottoUsedTicket.toString() shouldBe "[$selectedString]"
        }
    }
})
