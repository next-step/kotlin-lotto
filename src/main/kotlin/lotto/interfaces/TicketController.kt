package lotto.interfaces

import lotto.application.command.OrderTicketService
import lotto.common.execute.Executable
import lotto.domain.Order
import lotto.domain.enums.Prize
import lotto.domain.enums.TicketType
import lotto.domain.vo.LotteryNumber
import lotto.domain.vo.LotteryNumbers
import lotto.interfaces.ui.console.InputConsole
import lotto.interfaces.ui.console.OutputConsole

class TicketController(
    private val orderTicketService: OrderTicketService
) : Executable {

    override fun execute() {
        val order = queryOrder()

        viewTicketCount(order)

        viewLotteryNumber(order)

        val winLotteryNumbers = queryLastWeekWinLotteryNumbers()

        val bonusNumber = queryLastWeekBonusNumber()

        val prizeList = orderTicketService.confirmPrizeByOrder(winLotteryNumbers, order, bonusNumber)
        viewPrizeList(prizeList)

        val rateOfReturn = orderTicketService.calculateRateOfReturn(order, prizeList)
        viewRateOfReturn(rateOfReturn)
    }

    private fun queryOrder(): Order {
        val paymentPrice = InputConsole.queryPaymentPrice()
        return orderTicketService.orderTickets(paymentPrice = paymentPrice, ticketType = TicketType.AUTO)
    }

    private fun viewLotteryNumber(order: Order) {
        order.toLotteryNumbers().forEach { OutputConsole.printString(it.lotteryNumbers.toString()) }
    }

    private fun viewTicketCount(order: Order) {
        val countTicket = order.countTicket()
        OutputConsole.printTicketCount(countTicket)
    }

    private fun queryLastWeekWinLotteryNumbers(): LotteryNumbers {
        val inputNumbers = InputConsole.queryLastWeekWinLotteryNumbers()
        val lastWeekWinLotteryNumbers = inputNumbers.map { LotteryNumber(it) }.toList()
        return LotteryNumbers(lotteryNumbers = lastWeekWinLotteryNumbers)
    }

    private fun queryLastWeekBonusNumber(): LotteryNumber {
        val inputNumber = InputConsole.queryLastWeekBonusNumber()
        return LotteryNumber(value = inputNumber)
    }

    private fun viewPrizeList(prizeList: List<Prize>) {
        OutputConsole.printPrize()
        Prize.values().filter { it.isNotBoom() }.forEach { prize ->
            OutputConsole.printWinPrize(equalNumberCount = prize.equalNumberCount, amount = prize.amount, winCount = prizeList.count { it == prize })
        }
    }

    private fun viewRateOfReturn(rateOfReturn: Double) {
        OutputConsole.printRateOfReturn(rateOfReturn)
    }
}
