package lotto.view

class InputView {

    private fun read(description: String): String {
        println(description)
        return readLine()!!
    }

    private fun readLong(description: String) = read(description).toLong()

    fun budget() = readLong("구입금액을 입력해 주세요.")

    fun latestWinnerLotto(): List<Int> {
        val rawNumbers = read("지난 주 당첨 번호를 입력해 주세요.")
        return rawNumbers
            .split(NUMBER_DELIMITERS)
            .map { it.toInt() }
    }

    companion object {
        private const val NUMBER_DELIMITERS = ", "
    }
}
