package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class LotteryTicketMachineTest : StringSpec({
    "로또 티켓 머신은 티켓 구매 가격(1000원) 미만의 돈을 받으면 예외를 던진다" {
        shouldThrow<IllegalArgumentException> {
            LotteryTicketMachine(balance = Money(999))
        }
    }

    "로또 티켓 머신은 잔액 1000원 당 자동 로또 티켓 1장을 발권한다" {
        val sut = LotteryTicketMachine(balance = Money(14000))

        val result = sut.issueTicket()

        result.shouldNotBeNull()
    }

    "로또 티켓 머신의 잔액이 티켓 1장 가격보다 적으면 발권 시 null을 반환한다" {
        val sut = LotteryTicketMachine(balance = Money(1999))
        sut.issueTicket()

        val result = sut.issueTicket()

        sut.balance shouldBe Money(999)
        result.shouldBeNull()
    }

    "로또 티켓 머신은 잔액과 총 티켓 구매 비용을 제공할 수 있다" {
        val sut = LotteryTicketMachine(balance = Money(3000), totalCost = Money(2000))

        sut.balance shouldBe Money(3000)
        sut.totalCost shouldBe Money(2000)
    }

    "로또 티켓 머신은 티켓을 한 장 구매할 때마다 잔액을 티켓 비용(1000)만큼 차감한다" {
        val sut = LotteryTicketMachine(balance = Money(14000))
        sut.balance shouldBe Money(14000)

        val result = sut.issueTicket()

        result.shouldNotBeNull()
        sut.balance shouldBe Money(13000)
    }

    "로또 티켓 머신은 티켓을 한 장 구매할 때마다 총 구매 비용을 티켓 비용(1000)만큼 증가한다" {
        val sut = LotteryTicketMachine(balance = Money(1000), totalCost = Money.ZERO)
        sut.totalCost shouldBe Money.ZERO

        val result = sut.issueTicket()

        result.shouldNotBeNull()
        sut.totalCost shouldBe Money(1000)
    }
})
