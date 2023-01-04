package lotto.domain

class LottoNumber(private val number: Int) {
    init {
        require(LOTTO_NUMBER_RANGE.contains(number)) { "로또 숫자는 1부터 45까지 입니다." }
    }

    override fun toString() = number.toString()

    companion object {
        val LOTTO_NUMBER_RANGE = (1..45)
        private val NUMBERS = LOTTO_NUMBER_RANGE.map { LottoNumber(it) }

        fun of(value: Int): LottoNumber {
            return NUMBERS[value - 1]
        }
    }
}
