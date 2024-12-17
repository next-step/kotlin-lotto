package lotto.domain

data class LottoNumber(private val number: Int) {
    init {
        require(number in LOTTO_NUMBER_RANGE) { "${LOTTO_NUMBER_RANGE.first} ~ ${LOTTO_NUMBER_RANGE.last} 사이의 번호를 입력해 주세요." }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
        private val LOTTO_NUMBERS: MutableMap<Int, LottoNumber> = mutableMapOf()

        fun from(value: Int): LottoNumber {
            return LOTTO_NUMBERS.getOrPut(value) { LottoNumber(value) }
        }
    }
}
