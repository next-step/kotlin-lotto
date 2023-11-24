package lotto.presentation

class InputManager {
    fun inputPay(): Int {
        println(INPUT_NAME_OF_CARS_MESSAGE)
        return inputValueToInt()
    }

    fun inputWinningNumber(): List<Int> {
        println(INPUT_WINNING_NUMBER_MESSAGE)
        return inputUserValue().replace("\\s".toRegex(), "").split(",").map { it.toInt() }
    }

    fun inputSellManualLottoCount(): Int {
        println(INPUT_SELL_MANUAL_LOTTO_COUNT_MESSAGE)
        return inputValueToInt()
    }

    fun inputManualLottoNumbers(count: Int): List<String> {
        println(INPUT_MANUAL_LOTTO_NUMBER_MESSAGE)
        val input = mutableListOf<String>()
        repeat(count) {
            input.add(inputUserValue().replace("\\s".toRegex(), ""))
        }

        return input
    }

    fun inputBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER_MESSAGE)
        return inputValueToInt()
    }
    private fun inputValueToInt() = inputUserValue().toInt()

    private fun inputUserValue(): String {
        val input = readln()
        require(input.isNotBlank()) { INPUT_NOT_NULL_MESSAGE }
        return input.trim()
    }

    companion object {
        private const val INPUT_NAME_OF_CARS_MESSAGE = "구입금액을 입력해 주세요."
        private const val INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
        private const val INPUT_SELL_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
        private const val INPUT_MANUAL_LOTTO_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요."
        private const val INPUT_NOT_NULL_MESSAGE = "입력값을 입력해주세요."
    }
}
