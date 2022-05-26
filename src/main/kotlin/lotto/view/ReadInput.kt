package lotto.view

interface Input {
    fun readPurchaseAmount(): Int
    fun readLastWeekWinningNumbers(): List<Int>
}

class ReadInput : Input {
    override fun readPurchaseAmount() = readln().toIntOrThrow()
    override fun readLastWeekWinningNumbers(): List<Int> = readln().split(",").map { it.trim().toIntOrThrow() }

    private fun String.toIntOrThrow() = toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
}
