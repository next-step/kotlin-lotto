package lotto.interfaces

import lotto.application.command.OrderTicketService
import lotto.common.execute.Executable
import lotto.common.value.Quantity
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
        val totalPaymentPrice = InputConsole.queryPaymentPrice()

        val manualTicketCount = queryManualTicketCount()
        val manualTicketPrice = orderTicketService.availableTicketPrice(Quantity(manualTicketCount))
        val manualLotteryNumbersList = queryManualLotteryNumbersList(manualTicketCount)
        val manualOrderInfo = OrderTicketService.OrderInfo(
            paymentPrice = manualTicketPrice,
            ticketType = TicketType.MANUAL,
            lotteryNumbers = manualLotteryNumbersList
        )

        val autoTicketPrice = totalPaymentPrice - manualTicketPrice
        val autoOrderInfo = OrderTicketService.OrderInfo(
            paymentPrice = autoTicketPrice,
            ticketType = TicketType.AUTO
        )

        val orderInfo = listOf(manualOrderInfo, autoOrderInfo)
        return orderTicketService.orderTickets(orderInfo = orderInfo)
    }

    private fun queryManualLotteryNumbersList(manualTicketCount: Int): List<LotteryNumbers> {
        val manualLotteryNumbersList = InputConsole.queryManualLotteryNumbers(manualTicketCount)
        return manualLotteryNumbersList.map { lotteryNumbers ->
            LotteryNumbers(lotteryNumbers.map { LotteryNumber(it) }.toList())
        }
    }

    private fun queryManualTicketCount(): Int {
        return InputConsole.queryManualTicketCount()
    }

    private fun viewLotteryNumber(order: Order) {
        order.toLotteryNumbers().forEach { OutputConsole.printLotteryNumbers(it.toStringList()) }
    }

    private fun LotteryNumbers.toStringList(): List<String> {
        return this.lotteryNumbers.map { it.toString() }
    }

    private fun viewTicketCount(order: Order) {
        val manualTicketCount = order.countTicket(TicketType.MANUAL)
        val autoTicketCount = order.countTicket(TicketType.AUTO)
        OutputConsole.printTicketCount(manualTicketCount, autoTicketCount)
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
            OutputConsole.printWinPrize(
                equalNumberCount = prize.equalNumberCount(),
                amount = prize.amount,
                winCount = prizeList.count { it == prize },
                isBonusPrize = prize.isBonusPrize()
            )
        }
    }

    private fun viewRateOfReturn(rateOfReturn: Double) {
        OutputConsole.printRateOfReturn(rateOfReturn)
    }
}
