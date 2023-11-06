package lotto.domain

data class LottoNumber(val value: Int) {
    init {
        require(value in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { "로또 번호는 $MIN_LOTTO_NUMBER ~ $MAX_LOTTO_NUMBER 사이의 숫자만 가능합니다." }
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45

        private val lottoNumberPool: Map<Int, LottoNumber> = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).associateWith { LottoNumber(it) }

        fun from(value: Int): LottoNumber {
            return lottoNumberPool.getOrDefault(value, LottoNumber(value))
        }
    }
}
