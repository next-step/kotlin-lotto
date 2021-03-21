package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER) { "로또 번호는 $LOTTO_MINIMUM_NUMBER 이상 $LOTTO_MAXIMUM_NUMBER 여야 해요." }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        const val LOTTO_MINIMUM_NUMBER = 1
        const val LOTTO_MAXIMUM_NUMBER = 45

        private val NUMBERS: Map<Int, LottoNumber> = (LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER).associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber {
            return return NUMBERS[value] ?: throw IllegalArgumentException()
        }
    }
}
