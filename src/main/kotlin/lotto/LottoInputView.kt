package lotto

class LottoInputView {

    fun readInt(message: String): Int {
        println(message)
        return readln().toIntOrNull() ?: 0
    }

    fun readLottoNumber(message: String = DEFAULT_READ_LOTTO_NUMBER_MESSAGE): LottoNumber {
        println(message)
        val input = readln()
        val numbers = input.split(DEFAULT_LAST_WEEK_WINNING_NUMBER_DELIMITER)
            .map { it.trim().toIntOrNull() ?: 0 }
            .sorted()
            .toList()
        return LottoNumber(numbers)
    }

    companion object {
        private const val DEFAULT_LAST_WEEK_WINNING_NUMBER_DELIMITER = ","
        private const val DEFAULT_READ_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    }
}
