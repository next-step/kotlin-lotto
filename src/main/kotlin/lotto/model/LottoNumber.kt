package lotto.model

data class LottoNumber(val value: Int) {
    init {
        require(value in 1..46)
    }

    companion object {
        private val LOTTO_NUMBER_POOL = (1..46).map { LottoNumber(it) }

        fun random() = LOTTO_NUMBER_POOL.shuffled().first()
        fun of(input: String): LottoNumber {
            return LottoNumber(input.toInt())
        }
    }
}
