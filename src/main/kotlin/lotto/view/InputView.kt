package lotto.view

import lotto.InputParser
import lotto.domain.Lottery
import lotto.domain.LotteryGroup

object InputView {
    fun getInputDataInteger(message: String): Int {
        println("$message 입력해 주세요.")
        runCatching {
            val inputData = readlnOrNull()
            return InputParser.parseInputStringToInt(inputData)
        }.getOrElse {
            it.printStackTrace()
            return -1
        }
    }

    fun getLotteriesByHand(message: String, count: Int): LotteryGroup {
        println("$message 입력해 주세요.")
        runCatching {
            return lotteryGroup(count)
        }.getOrElse {
            it.printStackTrace()
            return LotteryGroup()
        }
    }

    private fun lotteryGroup(count: Int): LotteryGroup {
        val lotteries = mutableListOf<Lottery>()
        repeat(count) {
            val inputData = readlnOrNull() ?: ""
            val lottery = InputParser.parseLotteryNumbers(inputData)
            lotteries.add(Lottery(lottery))
        }
        return LotteryGroup(lotteries)
    }
}
