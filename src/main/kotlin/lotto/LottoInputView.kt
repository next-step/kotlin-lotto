package lotto

class LottoInputView {

    fun readInt(message: String): Int {
        println(message)
        return readln().toIntOrNull() ?: 0
    }

    fun readLottoNumbers(message: String): LottoNumber {
        println(message)
        val input = readln()
        val numbers = input.split(DEFAULT_LAST_WEEK_WINNING_NUMBER_DELIMITER)
            .map { it.trim().toIntOrNull() ?: 0 }
            .sorted()
            .toList()
        return LottoNumber(numbers)
    }

    companion object {
        const val DEFAULT_LAST_WEEK_WINNING_NUMBER_DELIMITER = ","
    }
}
