package lotto

interface IInput {
    fun readPurchaseAmount(): Int
    fun readLastWeekWinningNumbers(): List<Int>
}

class Input: IInput {
    override fun readPurchaseAmount() = readln().toIntOrThrow()
    override fun readLastWeekWinningNumbers(): List<Int> = readln().split(", ").map { it.toIntOrThrow()}

    private fun String.toIntOrThrow() = toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
}