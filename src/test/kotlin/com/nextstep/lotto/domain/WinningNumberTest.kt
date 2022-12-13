package com.nextstep.lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class WinningNumberTest : FunSpec({
    context("WinningNumber") {
        test("당첨번호를 초기화한다.") {
            shouldNotThrow<RuntimeException> {
                WinningNumber(
                    LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6)
                )
            }
        }

        test("당첨번호는 ${LottoTicket.LOTTO_TICKET_COUNT} 개 가 아니면 생성할 수 없다.") {
            listOf(
                setOf(LottoNumber.from(1)),
                setOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2)
                ),
                setOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3)
                ),
                setOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4)
                ),
                setOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4),
                    LottoNumber.from(5)
                ),
                setOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4),
                    LottoNumber.from(5),
                    LottoNumber.from(6),
                    LottoNumber.from(7)
                )
            ).forAll { input ->
                run {
                    val exception = shouldThrow<IllegalArgumentException> { WinningNumber(input) }
                    exception.message shouldBe "당첨 번호는 ${LottoTicket.LOTTO_TICKET_COUNT} 개의 로또번호가 필요합니다."
                }
            }
        }
    }
})
