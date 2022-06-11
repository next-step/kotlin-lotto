package lotto.view

import lotto.dto.OrderLotteryRequestDTO
import lotto.infra.port.IOSystem
import lotto.vo.LotteryNumber
import lotto.vo.LotteryNumberSet
import lotto.vo.Money

class InputMoneyView(private val ioSystem: IOSystem) {

    fun getMoney(): OrderLotteryRequestDTO {
        printInputMessage()
        val money = inputMoney()

        printInputManualLotteryNumber()
        val number = inputManualLotteryNumber()

        printInputLotteryNumbers()
        val lotteryNumberSets = inputNumbers(number)

        return OrderLotteryRequestDTO(money, lotteryNumberSets)
    }

    private fun printInputMessage() =
        ioSystem.write("구입 금액을 입력해 주세요.\n")

    private fun printInputManualLotteryNumber() =
        ioSystem.write("수동으로 구매할 로또 수를 입력해 주세요.\n")

    private fun printInputLotteryNumbers() =
        ioSystem.write("수동으로 구매할 번호를 입력해 주세요.\n")

    private fun inputMoney(): Money =
        ioSystem
            .read()
            .toInt()
            .let(::Money)

    private fun inputManualLotteryNumber() =
        ioSystem.read().toInt()

    private fun inputNumbers() =
        ioSystem
            .read()
            .split(",")
            .map(String::trim)
            .map(String::toInt)
            .map(::LotteryNumber)
            .let(::LotteryNumberSet)

    private fun inputNumbers(count: Int): List<LotteryNumberSet> =
        List(count) { inputNumbers() }
}
