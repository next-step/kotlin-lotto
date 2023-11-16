package lottery.view

object InputView {
    private const val INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요."
    private const val INPUT_PURCHASE_MANUAL_LOTTO_COUNT = "\n수동으로 구매할 로또 수를 입력해 주세요."
    private const val INPUT_PURCHASE_MANUAL_LOTTO_NUMBER = "\n수동으로 구매할 번호를 입력해 주세요."
    private const val INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "\n보너스 볼을 입력해 주세요."
    private const val INVALID_PURCHASE_AMOUNT_EXCEPTION = "구입 금액은 숫자로 입력해주세요."
    private const val INVALID_PURCHASE_MANUAL_LOTTO_COUNT_EXCEPTION = "구입 금액은 숫자로 입력해주세요."
    private const val INVALID_BONUS_NUMBER_EXCEPTION = "보너스 볼 번호를 숫자로 입력해주세요."
    private const val INVALID_MANUAL_NUMBERS_EXCEPTION = "로또 번호를 유효한 숫자로 입력해주세요."
    private const val INVALID_WINNING_NUMBERS_EXCEPTION = "당첨 번호를 유효한 숫자로 입력해주세요."
    private const val DELIMITER = ","

    fun inputAmount(): Int {
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        val input = readln()
        require(input.toIntOrNull() != null) { INVALID_PURCHASE_AMOUNT_EXCEPTION }
        return input.toInt()
    }

    fun inputManualLottoCount(): Int {
        println(INPUT_PURCHASE_MANUAL_LOTTO_COUNT)
        val input = readln()
        require(input.toIntOrNull() != null) { INVALID_PURCHASE_MANUAL_LOTTO_COUNT_EXCEPTION }
        return input.toInt()
    }

    fun inputManualLottoNumberMessage() {
        println(INPUT_PURCHASE_MANUAL_LOTTO_NUMBER)
    }

    fun inputManualLottoNumbers(): List<Int> {
        return readln().split(DELIMITER).map {
            require(it.toIntOrNull() is Int) { INVALID_MANUAL_NUMBERS_EXCEPTION }
            it.toInt()
        }
    }

    fun inputWinningNumbers(): List<Int> {
        println(INPUT_WINNING_NUMBERS)
        return readln().split(DELIMITER).map {
            require(it.toIntOrNull() is Int) { INVALID_WINNING_NUMBERS_EXCEPTION }
            it.toInt()
        }
    }

    fun inputBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER)
        val input = readln()
        require(input.toIntOrNull() != null) { INVALID_BONUS_NUMBER_EXCEPTION }
        return input.toInt()
    }
}
