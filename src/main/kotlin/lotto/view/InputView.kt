package lotto.view

import lotto.domain.InputParser
import lotto.domain.model.Count

object InputView {
    private const val INPUT_ERROR_MESSAGE = "입력 값이 잘못되었습니다"
    fun inputMoney(): Int {
        println("구입금액을 입력해주세요")
        val input = retryInputUntilInt(readln().toIntOrNull())
        println()
        return input
    }

    fun inputManualCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val input = retryInputUntilInt(readln().toIntOrNull())
        println()
        return input
    }

    fun inputManualNumbers(count: Count): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val numbers = mutableListOf<List<Int>>()
        repeat(count.value) {
            numbers.add(inputManualNumber())
        }
        println()
        return numbers
    }

    fun inputWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요")
        val numbers = mutableListOf<Int>()
        InputParser.parse(readln()).map {
            val value = it.toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
            numbers.add(value)
        }
        return numbers
    }

    fun inputBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        return retryInputUntilInt(readln().toIntOrNull())
    }

    private fun inputManualNumber(): List<Int> {
        val numbers = mutableListOf<Int>()
        val input = readln()
        InputParser.parse(input).map {
            val number = it.toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
            numbers.add(number)
        }
        return numbers
    }

    private fun retryInputUntilInt(input: Int?): Int {
        var value = input
        while (value == null) {
            println(INPUT_ERROR_MESSAGE)
            value = readln().toIntOrNull()
        }
        return value
    }
}
