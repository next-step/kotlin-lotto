package lotto.view

import lotto.data.NumberCombination

object InputView {

    private const val ERR_MSG_INVALID_NUMERIC_FORMAT = "입력된 값의 포맷이 숫자가 압니다."
    private const val ERR_MSG_OUT_OF_CASH_RANGE = "입력된 값이 구매 가능할 수 있는 금액의 범위를 벗어났습니다"
    private const val MIN_GAME_COST = 1000
    private const val MAX_GAME_COST = 100000

    fun inputCash(): Int {
        println("구입금액을 입력해 주세요.")
        val inputData = readln()
        validateCash(inputData)
        return inputData.toInt()
    }

    fun inputManualCnt(gameTimes: Int): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val inputData = readln()
        validateBuyManual(inputData, gameTimes)
        return inputData.toInt()
    }

    fun inputNumberCombination(manualGameTimes: Int): List<NumberCombination> {
        val numberCombinationList = mutableListOf<NumberCombination>()

        println("수동으로 구매할 번호를 입력해 주세요.")
        repeat(manualGameTimes) {
            val inputData = readln()
            numberCombinationList.add(NumberCombination(splitInputData(inputData)))
        }
        println()
        return numberCombinationList.toList()
    }

    fun inputWinningNumber(): NumberCombination {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val inputData = readln()
        println()
        return NumberCombination(splitInputData(inputData))
    }

    fun inputBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val inputData = readln()
        println()
        return inputData.toInt()
    }

    fun validateCash(inputData: String) {
        validateNumericFormat(inputData)
        validateNumberRange(inputData.toInt())
    }

    fun validateBuyManual(inputData: String, gameTimes: Int) {
        validateNumericFormat(inputData)
        validateManualTimes(inputData.toInt(), gameTimes)
    }

    private fun validateManualTimes(inputData: Int, gameTimes: Int) {
        require(gameTimes >= inputData) { "수동 게임 횟수가 총 게임 횟수를 초과하였습니다." }
    }

    fun splitInputData(inputData: String): List<Int> {
        val splitData = inputData.split(",").map { it.trim() }
        validateWinningNumber(splitData)
        return splitData.map { it.toInt() }
    }

    private fun validateNumericFormat(inputData: String) {
        require(inputData.toIntOrNull() != null) { ERR_MSG_INVALID_NUMERIC_FORMAT }
    }

    private fun validateNumberRange(inputData: Int) {
        require(inputData in MIN_GAME_COST..MAX_GAME_COST) { ERR_MSG_OUT_OF_CASH_RANGE }
    }

    private fun validateWinningNumber(inputData: List<String>) {
        inputData.forEach { require(it.toIntOrNull() != null) { ERR_MSG_INVALID_NUMERIC_FORMAT } }
    }
}
