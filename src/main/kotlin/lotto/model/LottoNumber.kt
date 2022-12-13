package lotto.model

data class LottoNumber(val value: Int) {
    init {
        require(value in LOTTO_NUMBER_RANGE)
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = 1..46
        private val LOTTO_NUMBER_POOL = LOTTO_NUMBER_RANGE.associateWith(::LottoNumber)

        fun random() = LOTTO_NUMBER_POOL[LOTTO_NUMBER_RANGE.random()]
            ?: throw IllegalArgumentException()

        fun of(input: String): LottoNumber {
            return LottoNumber(input.toInt())
        }
    }
}
