package com.nextstep.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class LottoMachineTest : BehaviorSpec({

    Given("LottoMachine#purchase") {
        val lottoMachine = LottoMachine()

        When("1000 보다 적은 금액이 입력되면") {
            Then("IllegalArgumentException 이 발생한다.") {
                shouldThrow<IllegalArgumentException> { lottoMachine.purchase(900) } shouldHaveMessage
                        "로또는 1000원부터 구매할 수 있습니다. amount: 900"
            }
        }

        When("금액이 1000원 이상 주어지면") {
            Then("1000원 당 1개의 LottoTicket 을 생성하고 LottoTickets 으로 리턴한다.") {
                val lottoTickets = lottoMachine.purchase(2500)
                lottoTickets.getCount() shouldBe 2
            }
        }
    }
})
