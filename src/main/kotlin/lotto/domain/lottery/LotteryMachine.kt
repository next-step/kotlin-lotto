package lotto.domain.lottery

import lotto.domain.Money
import lotto.domain.result.AutoLotteryPurchaseResult
import lotto.domain.result.LotteryPurchaseResult
import lotto.domain.result.ManualLotteryPurchaseResult
import lotto.scaleDown

object LotteryMachine {
    private val LOTTERY_PRICE = Money(1_000)

    fun issueAutoLotteryTicket(money: Money): LotteryPurchaseResult {
        val lotteryQuantity = getQuantity(money)
        val lotteries = List(lotteryQuantity) { generateNumbers() }
        val change = money - LOTTERY_PRICE * lotteryQuantity
        return AutoLotteryPurchaseResult(LotteryTicket(lotteries), change)
    }

    private fun getQuantity(money: Money): Int = (money / LOTTERY_PRICE).scaleDown().toInt()

    private fun generateNumbers(): Lottery {
        val lotteryNumbers = LotteryNumber.LOTTERY_NUMBER_RANGE.shuffled().take(6).map { LotteryNumber(it) }.toSet()
        return Lottery(lotteryNumbers)
    }

    fun issueManualLotteryTicket(money: Money, issueNumbers: List<Set<Int>>): LotteryPurchaseResult {
        val requiredMoney = LOTTERY_PRICE * issueNumbers.size
        require(money >= requiredMoney) { "수동으로 발급할 수 있는 금액이 충분하지 않습니다. money: $money, requiredMoney : $requiredMoney" }

        val lotteryTicket = issueNumbers.map { numbers ->
            Lottery(numbers.map { LotteryNumber(it) }.toSet())
        }.let { LotteryTicket(it) }
        val change = money - requiredMoney

        return ManualLotteryPurchaseResult(lotteryTicket, change)
    }
}
