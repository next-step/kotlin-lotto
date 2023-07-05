package lotto.domain

class Lotto(val numbers: LottoNumbers, val bonusNumber: Int?) {

    constructor(numbers: List<Int>, bonusNumber: Int?) : this(LottoNumbers(numbers.toSet()), bonusNumber)
    constructor(numbers: List<Int>) : this(LottoNumbers(numbers.toSet()), null)
    constructor(numbers: Set<Int>, bonusNumber: Int?) : this(LottoNumbers(numbers), bonusNumber)

    fun countMatch(lotto: Lotto): Int {
        return numbers.countMatch(lotto.numbers)
    }

    override fun toString(): String {
        return numbers.numbers.joinToString(
            prefix = "[",
            postfix = "]",
            separator = ", ",
        )
    }

    fun matchBonus(winningLotto: Lotto): Boolean {
        if (winningLotto.bonusNumber == null) {
            return false
        }
        return numbers.match(winningLotto.bonusNumber)
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_NUMBER_MIN = 1
        const val LOTTO_NUMBER_MAX = 45
    }
}
