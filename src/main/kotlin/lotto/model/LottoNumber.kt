package lotto.model

class LottoNumber private constructor(val value: Int) {
    init {
        require(value in LOTTO_NUMBER_RANGE)
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = 1..46
        private val LOTTO_NUMBER_POOL = LOTTO_NUMBER_RANGE.associateWith(::LottoNumber)

        fun getAllNumbers(): Collection<LottoNumber> {
            return LOTTO_NUMBER_POOL.values
        }

        fun of(value: Int): LottoNumber {
            return LOTTO_NUMBER_POOL[value] ?: throw IllegalArgumentException()
        }

        fun of(input: String): LottoNumber {
            return LOTTO_NUMBER_POOL[input.toInt()] ?: throw IllegalArgumentException()
        }
    }
}
