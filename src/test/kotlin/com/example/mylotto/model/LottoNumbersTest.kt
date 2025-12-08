package com.example.mylotto.model
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest :
    FunSpec({
        test("success") {
            val newTicket = LottoNumbers.auto()
            newTicket.numbers.size.shouldBe(6)
        }
    })
