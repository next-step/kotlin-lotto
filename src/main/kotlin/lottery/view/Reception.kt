package lottery.view

import lottery.domain.LotteryNumbers

object Reception {
    private const val LOTTERY_NUMBER_DELIMITERS = ","
    private const val START_INDEX = 1
    private const val LOTTERY_NUMBER_SIZE = 6

    fun receiveManualLotteryNumbers(countOfManualLottery: Int): List<LotteryNumbers> {
        return (START_INDEX..countOfManualLottery).map { LotteryNumbers(receiveLotteryNumbers()) }
    }

    fun receiveLotteryNumbers(): List<Int> {
        val splitedNumbers = readLineNotNull().split(LOTTERY_NUMBER_DELIMITERS)

        require(splitedNumbers.size == LOTTERY_NUMBER_SIZE) { "로또 번호는 6개이어야 합니다." }

        return splitedNumbers.map { it.toIntOrException() }
    }

    fun receiveNumber(): Int {
        return readLineNotNull().toIntOrException()
    }

    private fun readLineNotNull(): String {
        return readLine() ?: throw IllegalArgumentException("입력값이 존재하지 않습니다.")
    }

    private fun String.toIntOrException() =
        this.toIntOrNull() ?: throw IllegalArgumentException("value는 숫자여야 합니다. value : $this")
}
