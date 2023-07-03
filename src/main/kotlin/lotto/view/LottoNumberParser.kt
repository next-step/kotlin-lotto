package lotto.view

object LottoNumberParser {
    private const val DEFAULT_DELIMITER = ","

    fun splitInputLottoNumbers(inputLottoNumbers: String): List<Int> {
        return inputLottoNumbers
            .split(DEFAULT_DELIMITER)
            .map { validateLottoNumber(it) }
    }

    fun validateLottoNumber(inputNumber: String): Int {
        val number = inputNumber.trim().toIntOrNull()
        requireNotNull(number)

        return number
    }
}
