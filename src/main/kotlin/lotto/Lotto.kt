package lotto

import lotto.LottoConstants.LOTTO_SIZE
import lotto.LottoConstants.MAX_LOTTO_NUMBER
import lotto.LottoConstants.MIN_LOTTO_NUMBER

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { "로또는 6개의 숫자여야 합니다." }
        require(numbers.distinct().size == LOTTO_SIZE) { "로또 번호는 중복될 수 없습니다." }
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { "로또 번호는 1부터 45 사이여야 합니다." }
    }

    fun match(other: Lotto): Int {
        return numbers.count { other.numbers.contains(it) }
    }
}
