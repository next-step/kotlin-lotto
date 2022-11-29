package com.nextstep.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoSellerTest : FunSpec({
    context("LottoSeller") {
        test("LottoSeller는 주어진 금액만큼 로또 티켓을 발행한다.") {
            listOf(
                listOf(3000L, 3),
                listOf(1000L, 1),
                listOf(2500L, 2),
                listOf(4500L, 4),
                listOf(32100L, 32)
            ).forAll { (amount, ticketCount) ->
                val lottoTickets = LottoSeller.sellLotto(amount)
                lottoTickets.size() shouldBe ticketCount
            }
        }

        test("LottoSeller에게 음수인 금액으로 구매시 예외가 발생한다.") {
            val exception = shouldThrow<IllegalArgumentException> { LottoSeller.sellLotto(-1) }
            exception.message shouldBe "돈은 음수가 될 수 없습니다."
        }
    }
})
