package lotto

import lotto.LottoConstants.LOTTO_SIZE

class Lotto(val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_SIZE) { "로또는 6개의 숫자여야 합니다." }
        require(numbers.distinct().size == LOTTO_SIZE) { "로또 번호는 중복될 수 없습니다." }
    }

    fun match(other: Lotto): Int {
        return numbers.count { other.numbers.contains(it) }
    }

    fun sortedList(): List<LottoNumber> = numbers.sortedBy { it.number }
}
