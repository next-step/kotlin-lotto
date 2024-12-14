package autolotto.domain

import autolotto.constants.LottoConstants.LOTTO_TAKE_NUMBER
import autolotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import autolotto.constants.LottoConstants.MIN_LOTTO_NUMBER

class LottoNumber(private val numbers: Set<Int>) {
    init {
        require(numbers.size == LOTTO_TAKE_NUMBER) { "로또 번호는 6개여야 합니다." }
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { "로또 번호는 1~45 사이여야 합니다." }
    }

    fun getNumbers(): Set<Int> = numbers

    fun hasNumber(number: Int): Boolean {
        return this.numbers.contains(number)
    }

    fun hasNotNumber(number: Int): Boolean {
        return this.numbers.contains(number).not()
    }
}
