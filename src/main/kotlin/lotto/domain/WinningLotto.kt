package lotto.domain

data class WinningLotto(val lotto: Lotto, val bonusNumber: LottoNumber) {

    constructor(numbers: List<Int>, bonusNumber: Int) : this(Lotto(numbers), LottoNumber.from(bonusNumber))

    fun matchCount(other: Lotto): Int {
        val otherNumbers = other.numbers
        return lotto.numbers.intersect(otherNumbers).count()
    }
}
