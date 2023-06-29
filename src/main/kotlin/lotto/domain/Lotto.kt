package lotto.domain

data class Lotto(
    val lottoNumbers: List<LottoNumber>
) {
    init {
        require(lottoNumbers.size == 6) { INVALID_LOTTO_SIZE_ERROR_MESSAGE }
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private const val INVALID_LOTTO_SIZE_ERROR_MESSAGE = "로또번호는 6개 입니다."

        fun of(inputNumbers: String): Lotto {
            return Lotto(LottoNumbersParser.splitInputLottoNumbers(inputNumbers))
        }
    }
}
