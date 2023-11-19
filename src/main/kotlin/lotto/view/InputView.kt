package lotto.view

object InputView {
    private const val PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요."
    private const val PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입금액을 숫자로 입력해 주세요."
    private const val MANUAL_LOTTO_COUNT_QUESTION = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val MANUAL_LOTTO_COUNT_ERROR_MESSAGE = "[ERROR] 수동 구매 로또 수에 대해 숫자를 입력해 주세요"
    private const val MANUAL_LOTTO_NUMBERS_QUESTION = "수동으로 구매할 번호를 입력해 주세요."
    private const val MANUAL_LOTTO_NUMBERS_ERROR_MESSAGE = "[ERROR] 수동 구매 로또 번호는 , 로 구분된 숫자여야 합니다"
    private const val WINNING_NUMBERS_QUESTION = "지난 주 당첨 번호를 입력해 주세요."
    private const val WINNING_NUMBERS_ERROR_MESSAGE = "[ERROR] 당첨 번호는 , 로 구분된 숫자여야 합니다"
    private const val BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요."
    private const val BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 볼은 숫자여야 합니다"
    private const val LOTTO_NUMBER_DELIMITER = ", "

    fun getPurchaseAmount(): Int? {
        println(PURCHASE_AMOUNT_QUESTION)
        return readIntInput().also {
            if (it == null) println(PURCHASE_AMOUNT_ERROR_MESSAGE)
        }
    }

    fun getManualLottoNumbers(): List<List<Int>>? {
        println()
        val count = getManualLottoCount() ?: return null
        println()
        return getManualLottoNumbers(count)
    }

    fun getWinningNumbersInput(): List<Int>? {
        println()
        println(WINNING_NUMBERS_QUESTION)
        return parseLottoNumbers(readInput()).also {
            if (it == null) println(WINNING_NUMBERS_ERROR_MESSAGE)
        }
    }

    fun getBonusNumberInput(): Int? {
        println(BONUS_NUMBER_QUESTION)
        return readIntInput().also {
            if (it == null) println(BONUS_NUMBER_ERROR_MESSAGE)
        }
    }

    private fun readInput(): String = readlnOrNull()
        ?: throw IllegalArgumentException("입력 값이 없습니다.")

    private fun readIntInput(): Int? = readlnOrNull()?.toIntOrNull()

    private fun parseLottoNumbers(lottoNumbers: String): List<Int>? =
        lottoNumbers
            .split(LOTTO_NUMBER_DELIMITER)
            .map { it.toIntOrNull() }
            .takeIf { it.all { it != null } }
            ?.filterNotNull()

    private fun getManualLottoCount(): Int? {
        println(MANUAL_LOTTO_COUNT_QUESTION)
        return readIntInput().also {
            if (it == null) println(MANUAL_LOTTO_COUNT_ERROR_MESSAGE)
        }
    }

    private fun getManualLottoNumbers(count: Int): List<List<Int>>? {
        println(MANUAL_LOTTO_NUMBERS_QUESTION)
        return List(count) { parseLottoNumbers(readInput()) }
            .takeIf { it.all { it != null } }
            ?.filterNotNull()
            .also {
                if (it == null) println(MANUAL_LOTTO_NUMBERS_ERROR_MESSAGE)
            }
    }
}
