package lotto.domain

data class LottoNumbers(
    val numbers: List<Int>
) {

    companion object {
        private const val INVALID_NUMBER_ERROR_MESSAGE = "숫자가 아니거나 0이하는 로또 번호가 될 수 없습니다."

        fun of(inputNumbers: String): LottoNumbers {
            val parsedNumbers = LottoNumbersParser.splitInputLottoNumbers(inputNumbers)
            return LottoNumbers(validateNumbers(parsedNumbers))
        }

        private fun validateNumbers(numbers: List<Int?>): List<Int> {
            require(numbers.all { it != null && it > 0 }) { INVALID_NUMBER_ERROR_MESSAGE }
            return numbers.filterNotNull()
        }
    }
}
