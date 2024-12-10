package autolotto.domain

class LottoNumber(private val numbers: Set<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBERS_MAX_SIZE) { "로또 번호는 6개여야 합니다." }
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) { "로또 번호는 1~45 사이여야 합니다." }
    }

    fun getNumbers(): Set<Int> = numbers

    fun hasNumber(number: Int): Boolean {
        return this.numbers.contains(number)
    }

    companion object {
        private const val LOTTO_NUMBERS_MAX_SIZE = 6
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
    }
}
