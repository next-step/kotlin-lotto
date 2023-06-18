package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.domain.lottery.LotteryMachine

class
LotteryMachineTest : FreeSpec({
    "자동으로 개당 로또를 10,000원에 사면 10개의 로또가 나온다" {
        val result = LotteryMachine.issueLotteryTicket(Money(10_000))
        val lotteryTicket = result.lotteryTicket
        lotteryTicket.getNumbersCount() shouldBe 10
    }

    "구입 금액 보다 수동으로 구매할 로또 수가 많을 경우" {
        // given
        val money = Money(10_000)
        val issueNumbers = List(11) { (1..45).shuffled().take(6).toSet() }

        // when & then
        val requiredMoney = Money(11_000)
        shouldThrow<IllegalArgumentException> {
            LotteryMachine.issueManualLotteryTicket(money, issueNumbers)
        }.shouldHaveMessage("수동으로 발급할 수 있는 금액이 충분하지 않습니다. money: $money, requiredMoney : $requiredMoney")
    }

    "수동으로 구입 시 잔돈과 함께 로또 티켓을 준다" {
        forAll(
            table(
                headers("수동 발급 갯수", "잔액"),
                row(1, 9_000),
                row(2, 8_000),
                row(3, 7_000),
                row(4, 6_000),
                row(5, 5_000),
                row(6, 4_000),
                row(7, 3_000),
                row(8, 2_000),
                row(9, 1_000),
                row(10, 0),
            )
        ) { cnt, change: Long ->
            // given
            val money = Money(10_000)
            val issueNumbers = List(cnt) { (1..45).shuffled().take(6).toSet() }

            // when
            val result = LotteryMachine.issueManualLotteryTicket(money, issueNumbers)

            // then
            result.lotteryTicket.getNumbersCount() shouldBe cnt
            result.change shouldBe Money(change)
        }
    }
})
