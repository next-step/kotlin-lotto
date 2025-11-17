package com.example.mylotto.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoServiceTest :
    FunSpec({
        val lottoService = LottoService()

        test("generateLottoTickets") {
            // Example usage: Generate tickets for 5000 won
            val tickets = lottoService.generateLottoTickets(5000)
            tickets.size.shouldBe(5)
        }

        test("matchLottoTicket") {
            // Example usage: Match a ticket with winning numbers
        }

        test("matchLottoTickets") {
            // Example usage: Match multiple tickets with winning numbers
        }
    })
