package lotto.domain

data class WinningLottoNumbers(private val lottoNumbers: LottoNumbers) {
    fun getAllNumberOfMatches(lotteries: List<LottoNumbers>): List<Int> {
        return lotteries.map {
            lottoNumbers.getNumberOfMatch(it)
        }
    }

    companion object {
        private const val INVALID_INPUT_ERROR_MESSAGE = "당첨 번호는 숫자만 입력할 수 있습니다."

        fun from(input: String): WinningLottoNumbers {
            val strings = input.split(", ")
            val lottoNumbers = strings.map { verifyValue(it) }

            return WinningLottoNumbers(LottoNumbers(lottoNumbers))
        }

        private fun verifyValue(value: String): LottoNumber {
            val number = value.toIntOrNull() ?: throw IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE)
            return LottoNumber(number)
        }
    }
}
