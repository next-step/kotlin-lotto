package lotto.domain

object LottoNumbersParser {
    private const val DEFAULT_DELIMITER = ","

    fun splitInputLottoNumbers(inputLottoNumbers: String): List<Int?> {
        return inputLottoNumbers
            .split(DEFAULT_DELIMITER)
            .map { it.trim().toIntOrNull() }
    }
}
