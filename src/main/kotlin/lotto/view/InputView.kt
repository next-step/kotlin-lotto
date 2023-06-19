package lotto.view

class InputView {
    fun inputMoney(): Int {
        val input = readlnOrNull()?.toIntOrNull()
        requireNotNull(input)
        return input
    }

    fun inputWinningNumbers(): List<Int> {
        return readlnOrNull()?.split(",")?.map { it.trim().toInt() } ?: emptyList()
    }
}
