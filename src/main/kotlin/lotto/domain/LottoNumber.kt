package lotto.domain

class LottoNumber(private val number: Int) {
    init {
        require(Policy.LOTTO_NUMBER_RANGE.contains(number)) { "로또 숫자는 1부터 45까지 입니다." }
    }

    companion object {
        private val NUMBERS = Policy.LOTTO_NUMBER_RANGE.map { LottoNumber(it) }

        fun of(value: Int): LottoNumber {
            return NUMBERS[value - 1]
        }
    }
}