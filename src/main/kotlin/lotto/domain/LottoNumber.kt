package lotto.domain

data class LottoNumber(private val number: Int) {
    init {
        require(number in 1..45)
    }
    override fun toString(): String {
        return number.toString()
    }

    companion object {
        private val LOTTO_NUMBERS: MutableMap<Int, LottoNumber> = mutableMapOf()

        fun from(value: Int): LottoNumber {
            return LOTTO_NUMBERS.getOrPut(value) { LottoNumber(value) }
        }
    }
}