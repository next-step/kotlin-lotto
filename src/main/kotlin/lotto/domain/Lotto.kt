package lotto.domain

class Lotto(val numbers: Set<Int>) {
    init {
        validateLottoNumbers(numbers)
    }

    fun match(winningNumbers: Set<Int>): Int {
        validateLottoNumbers(winningNumbers)
        return numbers.count { winningNumbers.contains(it) }
    }

    private fun validateLottoNumbers(numbers: Set<Int>) {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또에 적힌 숫자는 6개입니다" }
        require(numbers.all { it in LOTTO_START_NUMBER..LOTTO_END_NUMBER }) { "로또에는 1 ~ 45 사이의 숫자만 적힐 수 있습니다" }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        const val LOTTO_PRICE = 1000
    }
}
