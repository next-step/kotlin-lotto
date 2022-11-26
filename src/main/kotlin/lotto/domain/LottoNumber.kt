package lotto.domain

@JvmInline
value class LottoNumber(private val number: Int) {
    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { INVALID_VALUE_ERROR_MESSAGE }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val INVALID_VALUE_ERROR_MESSAGE = "당첨 번호는 1 ~ 45 사이의 숫자여야 합니다."
        private val allLottoNumbers = (MIN_NUMBER..MAX_NUMBER).toSet()

        fun getAllLottoNumbers(): Set<LottoNumber> {
            return allLottoNumbers.map {
                LottoNumber(it)
            }.toSet()
        }
    }
}
