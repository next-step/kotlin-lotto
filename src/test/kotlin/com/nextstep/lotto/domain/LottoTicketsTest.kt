package com.nextstep.lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTicketsTest : FunSpec({
    context("LottoTickets") {
        test("로또 티켓 용지에서 결과를 직접 확인할 수 있다.") {
            val lottoTickets = LottoTickets(
                listOf(
                    LottoTicket(
                        listOf(
                            LottoNumber(1),
                            LottoNumber(2),
                            LottoNumber(3),
                            LottoNumber(4),
                            LottoNumber(5),
                            LottoNumber(6)
                        )
                    )
                )
            )

            val calculateResult = lottoTickets.calculateResult(
                WinningNumber(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(9),
                        LottoNumber(10)
                    )
                )
            )

            calculateResult.result.keys.first() shouldBe Rank.FOURTH
        }
    }
})
