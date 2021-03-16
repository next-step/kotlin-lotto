package controller

object Reception {
    private const val LOTTERY_NUMBER_DELIMITERS = ","

    fun receiveWinnerLottery(): List<Int> {
        val splitedNumbers = readLine()!!.split(LOTTERY_NUMBER_DELIMITERS)
        return splitedNumbers.map { it.toIntOrException() }
    }

    fun receiveMoney(): Int {
        val readNumber = readLine()!!
        return readNumber.toIntOrException()
    }

    private fun String.toIntOrException() =
        this.toIntOrNull() ?: throw IllegalArgumentException("value는 숫자여야 합니다. value : $this")
}
