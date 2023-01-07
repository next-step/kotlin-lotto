package lottery.ui

class InputView {
    fun getPurchasingAmount(): Long {
        println(PURCHASING_AMOUNT_MESSAGE)
        return readln().toLong()
    }

    fun getWinningNumber(): List<Int> {
        println(GET_WINNING_NUMBER_MESSAGE)
        return readln()
            .split(DELIMITER)
            .map { it.toInt() }
    }

    companion object {
        private const val PURCHASING_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val GET_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
        private const val DELIMITER = ","
    }
}
