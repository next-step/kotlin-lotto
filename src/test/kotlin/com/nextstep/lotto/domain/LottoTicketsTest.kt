package com.nextstep.lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTicketsTest : FunSpec({
    context("LottoTickets") {
        test("로또 티켓 용지에서 1등 결과를 직접 확인할 수 있다.") {
            val lottoTickets = LottoTickets(
                listOf(
                    LottoTicket(LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6))
                )
            )

            val calculateResult = lottoTickets.calculateResult(
                WinningNumber(
                    LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6)
                ),
                LottoNumber(7)
            )

            calculateResult.result.keys.first() shouldBe Rank.FIRST
        }

        test("로또 티켓 용지에서 2등 결과를 직접 확인할 수 있다.") {
            val lottoTickets = LottoTickets(
                listOf(
                    LottoTicket(LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6))
                )
            )

            val calculateResult = lottoTickets.calculateResult(
                WinningNumber(
                    LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 4, 5, 10)
                ),
                LottoNumber(6)
            )

            calculateResult.result.keys.first() shouldBe Rank.SECOND
        }

        test("로또 티켓 용지에서 3등 결과를 직접 확인할 수 있다.") {
            val lottoTickets = LottoTickets(
                listOf(
                    LottoTicket(LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6))
                )
            )

            val calculateResult = lottoTickets.calculateResult(
                WinningNumber(
                    LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 4, 5, 12)
                ),
                LottoNumber(9)
            )

            calculateResult.result.keys.first() shouldBe Rank.THIRD
        }

        test("로또 티켓 용지에서 4등 결과를 직접 확인할 수 있다.") {
            val lottoTickets = LottoTickets(
                listOf(
                    LottoTicket(LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6))
                )
            )

            val calculateResult = lottoTickets.calculateResult(
                WinningNumber(
                    LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 4, 9, 10)
                ),
                LottoNumber(1)
            )

            calculateResult.result.keys.first() shouldBe Rank.FOURTH
        }

        test("로또 티켓 용지에서 5등 결과를 직접 확인할 수 있다.") {
            val lottoTickets = LottoTickets(
                listOf(
                    LottoTicket(LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6))
                )
            )

            val calculateResult = lottoTickets.calculateResult(
                WinningNumber(
                    LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 10, 11, 12)
                ),
                LottoNumber(9)
            )

            calculateResult.result.keys.first() shouldBe Rank.FIFTH
        }
    }
})
