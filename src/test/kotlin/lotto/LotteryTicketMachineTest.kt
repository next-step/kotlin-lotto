package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class LotteryTicketMachineTest : StringSpec({
    "로또 티켓 머신은 티켓 구매 가격(1000원) 미만의 돈을 받으면 예외를 던진다" {
        shouldThrow<IllegalArgumentException> {
            LotteryTicketMachine(999)
        }
    }

    "로또 티켓 머신은 잔액 1000원 당 자동 로또 티켓 1장을 발권한다" {
        val sut = LotteryTicketMachine(14000)

        val result = sut.issueTicket()

        sut.balance shouldBe 13000
        result.shouldNotBeNull()
    }

    "로또 티켓 머신의 잔액이 티켓 1장 가격보다 적으면 발권 시 null을 반환한다" {
        val sut = LotteryTicketMachine(1999)
        sut.issueTicket()

        val result = sut.issueTicket()

        sut.balance shouldBe 999
        result.shouldBeNull()
    }
})
