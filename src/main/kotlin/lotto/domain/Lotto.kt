package lotto.domain

class Lotto(val numbers: Set<Int>, val bonusNumber: Int?) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "로또 번호는 1부터 45 사이여야 합니다." }
    }

    constructor(numbers: List<Int>, bonusNumber: Int?) : this(numbers.toSet(), bonusNumber)
    constructor(numbers: List<Int>) : this(numbers.toSet(), null)

    fun countMatch(lotto: Lotto): Int {
        return numbers
            .intersect(lotto.numbers)
            .size
    }

    override fun toString(): String {
        return numbers.joinToString(
            prefix = "[",
            postfix = "]",
            separator = ", ",
        )
    }

    fun matchBonus(winningLotto: Lotto): Boolean {
        numbers.find { it == winningLotto.bonusNumber }?.let { return true }
        return false
    }
}
