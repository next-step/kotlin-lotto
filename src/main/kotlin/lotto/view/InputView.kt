package lotto.view

object InputView {
    private const val INPUT_MONEY = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."

    fun readMoney(): String? {
        println(INPUT_MONEY)
        return readLine()
    }

    fun readWinningNumbers(): String? {
        println(INPUT_WINNING_NUMBERS)
        return readLine()
    }
}
