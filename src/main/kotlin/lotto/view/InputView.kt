package lotto.view

import lotto.domain.Lotto

class InputView {
    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val input = readlnOrNull()?.toIntOrNull()
        requireNotNull(input)
        return input
    }

    fun inputWinningNumbers(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers: List<Int> = readlnOrNull()?.split(",")?.map { it.trim().toInt() } ?: emptyList()
        return Lotto(*winningNumbers.toIntArray())
    }
}
