package lotto.domain

class LottoNumber(val lottoNumber: Int) {
    init {
        validateInLottoNumberBounds(lottoNumber)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumber

        return lottoNumber == other.lottoNumber
    }

    override fun hashCode(): Int {
        return lottoNumber
    }

    companion object {
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
        val LOTTO_NUMBER_BOUNDS = MINIMUM_NUMBER..MAXIMUM_NUMBER
        fun validateInLottoNumberBounds(lottoNumber: Int) {
            require(lottoNumber in LOTTO_NUMBER_BOUNDS) { "로또 범위의 숫자만 가능합니다. 입력값을 다시 확인하세요." }
        }
    }
}
