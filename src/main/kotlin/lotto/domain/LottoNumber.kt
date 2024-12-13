package lotto.domain

data class LottoNumber(private val number: Int) {
    override fun toString(): String {
        return number.toString()
    }

    companion object {
        private val LOTTO_NUMBERS: MutableMap<Int, LottoNumber> = mutableMapOf()

        fun from(value: Int): LottoNumber {
            require(value in 1..45)
            return LOTTO_NUMBERS.getOrPut(value) { LottoNumber(value) }
        }
    }
}
