package lotto.domain

object LottoNumbersParser {
    private const val DEFAULT_DELIMITER = ","

    fun splitInputLottoNumbers(inputLottoNumbers: String): List<LottoNumber> {
        val splittedNumbers = inputLottoNumbers
            .split(DEFAULT_DELIMITER)
            .map { it.trim().toIntOrNull() }

        return validateSplittedNumbers(splittedNumbers).map { LottoNumber(it) }
    }

    private fun validateSplittedNumbers(splittedNumbers: List<Int?>): List<Int> {
        splittedNumbers.requireNoNulls()

        return splittedNumbers.filterNotNull()
    }
}
