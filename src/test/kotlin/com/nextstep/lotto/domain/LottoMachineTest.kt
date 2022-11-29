package com.nextstep.lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : FunSpec({
    context("LottoMachine") {
        test("LottoMachine은 주어진 개수만큼 랜덤한 로또 번호가 찍힌 로또 티켓을 발행한다.") {
            val lottoTickets = LottoMachine.issue(3)
            lottoTickets.size() shouldBe 3
        }
    }
})
