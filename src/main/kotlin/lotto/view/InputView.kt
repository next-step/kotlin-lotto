package lotto.view

object InputView {
    private const val WINNING_NUMBER_DELIMITER = ", "

    operator fun invoke(msg: String): Long {
        println(msg)
        return readln().toLong()
    }

    fun winningNumber(msg: String): List<Int> {
        println(msg)
        return readln().split(WINNING_NUMBER_DELIMITER).map { it.toInt() }
    }

    fun bonusBall(msg: String): Int {
        println(msg)
        return readln().toInt()
    }
}
