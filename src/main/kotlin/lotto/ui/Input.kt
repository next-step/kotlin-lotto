package lotto.ui

object Input {

    private const val READ_MONEY_MESSAGE = "구입금액을 입력해 주세요."
    private const val READ_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."

    fun readMoney(): Long {
        println(READ_MONEY_MESSAGE)
        return readln().toLong()
    }

    fun readWinningNumbers(): String {
        println()
        println(READ_WINNING_NUMBERS_MESSAGE)
        return readln()
    }
}
