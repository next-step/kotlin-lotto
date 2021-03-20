package lottery.controller

object Reception {
    private const val LOTTERY_NUMBER_DELIMITERS = ","

    fun receiveWinnerLottery(): List<Int> {
        val splitedNumbers = readLineNotNull().split(LOTTERY_NUMBER_DELIMITERS)
        return splitedNumbers.map { it.toIntOrException() }
    }

    fun receiveNumber(): Int {
        return readLineNotNull().toIntOrException()
    }

    private fun readLineNotNull(): String {
        val readLine = readLine()
        require(readLine != null) { "입력값이 존재하지 않습니다." }
        return readLine
    }

    private fun String.toIntOrException() =
        this.toIntOrNull() ?: throw IllegalArgumentException("value는 숫자여야 합니다. value : $this")
}
