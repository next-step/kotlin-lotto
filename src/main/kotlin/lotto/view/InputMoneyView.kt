package lotto.view

import lotto.domain.Lottery
import lotto.domain.LotteryNumberSet
import lotto.dto.OrderLotteryRequestDTO
import lotto.infra.port.IOSystem
import lotto.vo.LotteryNumber
import lotto.vo.Money

class InputMoneyView(private val ioSystem: IOSystem) {

    fun orderLottery(): OrderLotteryRequestDTO {
        printInputMessage()
        val money = inputMoney()

        printInputManualLotteryNumber()
        val number = inputManualLotteryNumber()

        printInputLotteryNumbers()
        val lotteryNumberSets = inputNumbers(number)

        return OrderLotteryRequestDTO(
            Money(money),
            lotteryNumberSets,
            calculateAutoLotteryNum(money, lotteryNumberSets.size)
        )
    }

    private fun printInputMessage() =
        ioSystem.write("구입 금액을 입력해 주세요.\n")

    private fun printInputManualLotteryNumber() =
        ioSystem.write("수동으로 구매할 로또 수를 입력해 주세요.\n")

    private fun printInputLotteryNumbers() =
        ioSystem.write("수동으로 구매할 번호를 입력해 주세요.\n")

    private fun inputMoney(): Int =
        ioSystem
            .read()
            .toInt()

    private fun inputManualLotteryNumber() =
        ioSystem.read().toInt()

    private fun inputNumbers(): LotteryNumberSet =
        try {
            ioSystem
                .read()
                .split(",")
                .map(String::trim)
                .map(String::toInt)
                .map(::LotteryNumber)
                .let(::LotteryNumberSet)
        } catch (exception: Exception) {
            ioSystem.write("잘못된 형식의 번호를 입력하셨습니다. 다시 입력해주세요.")
            inputNumbers()
        }

    private fun inputNumbers(count: Int): List<LotteryNumberSet> = List(count) { inputNumbers() }

    private fun calculateAutoLotteryNum(money: Int, manualLotteryNumber: Int): Int {
        val manualLotteryAmount = manualLotteryNumber * Lottery.PRICE
        return (money - manualLotteryAmount) / Lottery.PRICE
    }
}
