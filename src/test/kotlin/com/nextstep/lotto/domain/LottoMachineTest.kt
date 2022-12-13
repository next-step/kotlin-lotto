package com.nextstep.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoMachineTest : FunSpec({
    context("LottoMachine") {
        test("LottoMachine은 주어진 개수만큼 랜덤한 로또 번호가 찍힌 로또 티켓을 발행한다.") {
            val lottoTickets = LottoMachine.issue(3)
            lottoTickets.size() shouldBe 3
        }

        test("LottoMachine은 음수로 발행하면 예외가 발생한다.") {
            val exception = shouldThrow<IllegalArgumentException> { LottoMachine.issue(-3) }
            exception.message shouldBe "양수로 발행 해야 합니다."
        }
    }
})
