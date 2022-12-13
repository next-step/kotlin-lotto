package com.nextstep.lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTicketsTest : FunSpec({
    context("LottoTickets") {
        test("로또 티켓 용지에서 결과를 직접 확인할 수 있다.") {
            val lottoTickets = LottoTickets(
                listOf(
                    LottoTicket(LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6))
                )
            )

            val calculateResult = lottoTickets.calculateResult(
                WinningNumber(
                    LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 4, 9, 10)
                )
            )

            calculateResult.result.keys.first() shouldBe Rank.FOURTH
        }
    }
})
