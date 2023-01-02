package lotto.model

class LottoNumber private constructor(val value: Int) {
    init {
        require(value in LOTTO_NUMBER_RANGE) {
            "로또 숫자는 $LOTTO_NUMBER_RANGE 범위를 벗어날 수 없습니다. value: $value"
        }
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = 1..46
        private val LOTTO_NUMBER_POOL = LOTTO_NUMBER_RANGE.associateWith(::LottoNumber)

        fun getAllNumbers(): Collection<LottoNumber> {
            return LOTTO_NUMBER_POOL.values
        }

        fun of(value: Int): LottoNumber {
            return LOTTO_NUMBER_POOL[value] ?: LottoNumber(value)
        }

        fun of(value: String): LottoNumber {
            return LOTTO_NUMBER_POOL[value.trim().toInt()] ?: LottoNumber(value.trim().toInt())
        }
    }
}
