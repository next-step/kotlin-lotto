package lotto.view

import lotto.domain.model.Count

object InputView {
    fun inputMoney(): String {
        println("구입금액을 입력해주세요")
        val input = readln()
        println()
        return input
    }

    fun inputManualCount(): String {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val input = readln()
        println()
        return input
    }

    fun inputManualNumbers(count: Count): List<String> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val inputs = mutableListOf<String>().apply {
            repeat(count.value) {
                add(readln())
            }
        }
        println()
        return inputs
    }

    fun inputWinningNumbers(): String {
        println("지난 주 당첨 번호를 입력해 주세요")
        return readln()
    }

    fun inputBonusBall(): String {
        println("보너스 볼을 입력해 주세요.")
        return readln()
    }
}
