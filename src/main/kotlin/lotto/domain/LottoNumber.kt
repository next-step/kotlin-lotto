package lotto.domain

class LottoNumber(private val number: Int) {
    init {
        require(RANGE.contains(number)) { "로또 숫자는 1부터 45까지 입니다." }
    }

    companion object {
        private val RANGE = (1..45)
        private val NUMBERS = RANGE.map { LottoNumber(it) }

        fun of(value: Int): LottoNumber {
            return NUMBERS[value - 1]
        }
    }
}