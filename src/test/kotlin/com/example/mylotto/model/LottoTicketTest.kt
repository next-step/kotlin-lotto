package com.example.mylotto.model
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTicketTest :
    FunSpec({
        test("success") {
            val newTicket = LottoTicket.ofAutomatic()
            newTicket.numbers.size.shouldBe(6)
        }
    })
