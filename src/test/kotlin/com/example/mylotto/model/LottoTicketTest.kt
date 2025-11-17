package com.example.mylotto.model
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTicketTest :
    FunSpec({
        test("should allow exactly 6 unique LottoNumbers in a LottoTicket") {
            val validTicket =
                LottoTicket(
                    setOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                )
            validTicket.numbers.size.shouldBe(6)
        }

        test("should throw an exception if less than 6 numbers are provided") {
            shouldThrow<IllegalArgumentException> {
                LottoTicket(
                    setOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                    ),
                )
            }
        }

        test("should throw an exception if more than 6 numbers are provided") {
            shouldThrow<IllegalArgumentException> {
                LottoTicket(
                    setOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                        LottoNumber(7),
                    ),
                )
            }
        }
    })
