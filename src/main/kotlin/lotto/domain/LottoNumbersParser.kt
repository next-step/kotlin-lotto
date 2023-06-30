package lotto.domain

object LottoNumbersParser {
    private const val DEFAULT_DELIMITER = ","

    fun splitInputLottoNumbers(inputLottoNumbers: String): List<Int> {
        val splittedNumbers = inputLottoNumbers
            .split(DEFAULT_DELIMITER)
            .map { it.trim().toIntOrNull() }

        return validateSplittedNumbers(splittedNumbers)
    }

    private fun validateSplittedNumbers(splittedNumbers: List<Int?>): List<Int> {
        splittedNumbers.requireNoNulls()

        return splittedNumbers.filterNotNull()
    }
}
