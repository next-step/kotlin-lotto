package lotto

class LottoInputView {

    fun readPurchaseAmountFromConsole(message: String = DEFAULT_PURCHASE_AMOUNT_READ_MESSAGE): Int {
        println(message)
        return readln().toIntOrNull() ?: 0
    }

    fun readLastWeekWinningLottoNumberFromConsole(message: String = DEFAULT_LAST_WEEK_WINNING_NUMBER_READ_MESSAGE): WinningLottoNumber {
        println(message)
        val input = readln()
        val numbers = input.split(DEFAULT_LAST_WEEK_WINNING_NUMBER_DELIMITER)
            .map { it.trim().toIntOrNull() ?: 0 }
            .sorted()
            .toList()
        return WinningLottoNumber(LottoNumber(numbers), 1)
    }

    companion object {
        const val DEFAULT_LAST_WEEK_WINNING_NUMBER_DELIMITER = ","
        const val DEFAULT_PURCHASE_AMOUNT_READ_MESSAGE = "구입금액을 입력해 주세요."
        const val DEFAULT_LAST_WEEK_WINNING_NUMBER_READ_MESSAGE = "구입금액을 입력해 주세요."
    }
}
